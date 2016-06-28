import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class DownloadFiles {

	private static String server = "www.jamstudy.com";
	private static int port = 21;
	private static String username = "a0430967";
	private static String password = "hMIo9L3hAxRwRF";

	public static void downloadFiles() {
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
			FTPFile[] ftpFiles = ftpClientObject.listFiles();
			boolean allFilesDownloaded = true;
			if (ftpFiles != null && ftpFiles.length > 0) {
				for (FTPFile file : ftpFiles) {
					if (!file.isFile()) {
						continue;
					}
					System.out.println("File is " + file.getName());
					OutputStream output = new FileOutputStream("C:/FtpFiles"
							+ "/" + file.getName());
					boolean success = ftpClientObject.retrieveFile(
							file.getName(), output);
					output.close();
					if (success) {
						System.out.println("File " + file.getName()
								+ " has been downloaded successfully.");
					} else {
						System.out.println("File + " + file.getName()
								+ " hasn't been downloaded.");
						allFilesDownloaded = false;
					}
				}
				if (!allFilesDownloaded) {
					JOptionPane.showMessageDialog(null,
							"Not all files were downloaded!");
				} else {
					JOptionPane.showMessageDialog(null,
							"All the files were downloaded!");
				}
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
