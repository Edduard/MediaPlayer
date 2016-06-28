

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegisterClass {
	public static boolean registerUser(String username, String password) {
		URL url;
		try {
			url = new URL("http://www.jamstudy.com/register.php");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
					conn.getOutputStream());
			writer.write("username=" + username + "&password=" + password);
			writer.flush();
			String line;
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
			}
			writer.close();
			reader.close();
			if (sb != null && sb.toString().contains("\"success\":1")) {
				return true;
			} else {
				return false;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
