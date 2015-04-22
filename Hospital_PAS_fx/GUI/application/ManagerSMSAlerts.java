package application;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 
 * @author Hannah
 *
 */

public class ManagerSMSAlerts {
	
	
	
	public String sendSms() {
		try {
			// Construct data from TxtLocal
			String user = "username=" + "hmcdade767@gmail.com";
			String hash = "&hash=" + "64007dc125b1e33d8204dd6c6aaf10ce83c12fb7";
			String message = "&message=" + "I'm sending this SMS via Eclipse!";
			String sender = "&sender=" + "Hannah";
			String numbers = "&numbers=" + "07718663689";

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL(
					"https://api.txtlocal.com/send/?").openConnection();
			
			//data to be sent
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length",
					Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}
}
