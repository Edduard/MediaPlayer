import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import javax.swing.JOptionPane;

public class Starter {

	private File file;
	private File[] files;

	public void setFile(String PathToFile, FileType fileType, int counter) {
		if (fileType == FileType.PHOTO) {
			file = new File(PathToFile);
			files = file.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".jpg")
							|| name.toLowerCase().endsWith(".png");
				}
			});
			if (files.length != 0) {
				file = files[counter].getAbsoluteFile();
			} else {
				JOptionPane.showMessageDialog(null, "No photos are available!");
			}
		} else if (fileType == FileType.VIDEO) {
			file = new File(PathToFile);
			files = file.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".mkv")
							|| name.toLowerCase().endsWith(".mp4")
							|| name.toLowerCase().endsWith(".avi")
							|| name.toLowerCase().endsWith(".3gp");
				}
			});
			if (files.length != 0) {
				file = files[counter].getAbsoluteFile();
			} else {
				JOptionPane.showMessageDialog(null, "No videos are available!");
			}
		}
	}

	public File getFile() {
		return file;
	}

	public Path getFilePath() {
		return file.toPath();
	}

	public File[] getFiles() {
		return files;
	}

	public void begin() {
		try {
			Runtime.getRuntime().exec(
					"rundll32 SHELL32.DLL,ShellExec_RunDLL "
							+ getFile().getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
