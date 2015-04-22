package application;

/**
 * The class represent the application, application will start from this class
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GUIMain extends Application {

	public final static int REFRESHTIME = 1000;

	/**
	 * the limit number of treatment room,it is global variable
	 */
	public final static int NUMBERS_OF_ROOM = 1;
	/**
	 * the limit number of on call team
	 */
	public final static int NUMBERS_OF_ONCALLTEAM = 1;

	/**
	 * all treatment room in PAS,it is global variable
	 */
	public static TreatmentRoom[] treatmentRoom;

	/**
	 * all on call team in PAS,it is global variable
	 */
	public static List<OnCallTeam> onCallTeamList;
	/**
	 * patient queue in PAS,it is global variable
	 */
	public static PatientQueue patientQueue;

	/**
	 * all patient in PAS,it is global variable
	 */
	public static List<Patient> allPatientList;

	/**
	 * alert in PAS,it is global variable
	 */
	public static String alert;
	List<Staff> staffs = new ArrayList<Staff>();

	public static Patient nextPatient;
	public static Staff user;

	/**
	 * Initialize all global vars
	 * 
	 * @author Jiang Zhe Heng
	 */
	public void start(Stage primaryStage) {
		allPatientList = new ArrayList<Patient>();
		allPatientList = new ArrayList<Patient>();
		patientQueue = new PatientQueue();
		treatmentRoom = new TreatmentRoom[NUMBERS_OF_ROOM];
		for (int loop = 0; loop < NUMBERS_OF_ROOM; loop++) {
			GUIMain.treatmentRoom[loop] = new TreatmentRoom(loop, false);
		}
		onCallTeamList = new ArrayList<OnCallTeam>();
		for (int loop = 0; loop < NUMBERS_OF_ONCALLTEAM; loop++) {
			GUIMain.onCallTeamList.add(new OnCallTeam());
		}
		try {

			Parent root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));

			Scene scene = new Scene(root, 450, 400);

			primaryStage.setTitle("FXML Welcome");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			Thread myThread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(REFRESHTIME);
							Platform.runLater(new Runnable() {

								@Override
								public void run() {
									refresh();
									
									// adding the PatientQueue class and sendSMS
									// method to allow the SMS to be sent to the
									// on call team
									PatientQueue.sendSMS();

								}
							});

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			myThread.setDaemon(true);
			myThread.start();

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void refresh() {
		patientQueue.sort(new SortPatientComparator());
	}

	/**
	 * the method is used to get all staffs in PAS
	 * 
	 * @author Jiang Zhe Heng
	 * @return
	 */
	private static List<Staff> getAllStaff() {
		List<Staff> allStaff = new ArrayList<Staff>();
		String url = "jdbc:mysql://web2.eeecs.qub.ac.uk/40108307";
		Connection con;
		Statement stmt;
		// loading driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		// making the connection
		try {
			con = DriverManager.getConnection(url, "40108307", "CZB6355");
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			Staff staff = new Staff();
			ResultSet rs = stmt.executeQuery("select * from STAFF");
			while (rs.next()) {
				staff.setStaffID(Integer.parseInt(rs.getString("STAFF_ID")));
				staff.setTitle(rs.getString("TITLE"));
				staff.setFirstName(rs.getString("FIRST_NAME"));
				staff.setLastName(rs.getString("LAST_NAME"));
				staff.setPassword(rs.getString("STAFF_PASSWORD"));
				staff.setRole(rs.getString("STAFF_ROLE"));
				staff.setTeam(rs.getString("STAFF_TEAM"));
				staff.setEmail(rs.getString("EMAIL_ADDRESS"));
				staff.setTelephone(rs.getString("TELEPHONE"));
				allStaff.add(staff);
			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return allStaff;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
