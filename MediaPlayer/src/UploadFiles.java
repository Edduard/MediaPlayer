

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class UploadFiles {

	private static String server = "www.jamstudy.com";
	private static int port = 21;
	private static String username = "a0430967";
	private static String password = "hMIo9L3hAxRwRF";

	public static void uploadFiles() {
		FTPClient ftpClientObject = new FTPClient();
		try {
			ftpClientObject.connect(server, port);
			ftpClientObject.login(username, password);
			ftpClientObject.enterLocalPassiveMode();
			ftpClientObject.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClientObject
					.changeWorkingDirectory("/public_html/img/Faculty_Logos");
			System.out.println("Current directory is "
					+ ftpClientObject.printWorkingDirectory());
			File dir = new File("C:/FtpFiles");
			File[] files = dir.listFiles();
			boolean allFilesUploaded = true;
			if (files != null) {
				for (File f : files) {
					InputStream inputStream = new FileInputStream(f);
					boolean success = ftpClientObject.storeFile(f.getName(),
							inputStream);
					inputStream.close();
					if (success) {
						System.out.println("File " + f.getName()
								+ " has been uploaded successfully.");
					} else {
						System.out.println("File + " + f.getName()
								+ " hasn't been uploaded.");
						allFilesUploaded = false;
					}
				}
			}
			if (!allFilesUploaded) {
				JOptionPane.showMessageDialog(null,
						"Not all files were uploaded!");
			} else {
				JOptionPane.showMessageDialog(null,
						"All the files were uploaded!");
			}
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClientObject.isConnected()) {
					ftpClientObject.logout();
					ftpClientObject.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
