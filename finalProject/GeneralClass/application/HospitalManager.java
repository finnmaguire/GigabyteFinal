package application;

public class HospitalManager extends Staff implements IHospitalManager {

	private int contactNum;
	private String email;

	public HospitalManager() {

	}

	public HospitalManager(String title, String firstName, String lastName,
			char gender, int staffID, String password, int contactNum,
			String email) {
		super(title, firstName, lastName, gender, staffID, password);
		this.contactNum = contactNum;
		this.email = email;
	}

	public int getContactNum() {
		return contactNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}

	

	@Override
	public void displayAll() {
		super.displayAll();
		System.out.println("Contact Number: " + this.contactNum);
		System.out.println("Email: " + this.email);
	}

	/**
	 * Method to display all staff 
	 */
	@Override
	public void DisplayAllStaff() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method to display current status of treatment rooms
	 */
	@Override
	public void DisplayTreatmentRooms() {
		// TODO Auto-generated method stub
		
	}
}
