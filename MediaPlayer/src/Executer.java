import java.awt.AWTException;
import java.io.File;

import org.apache.commons.io.FilenameUtils;

public class Executer {
	String inputCommand;

	static Starter p;
	static Commander c;
	static Focuser f;
	static int videoCounter = 0;

	public static void start() throws AWTException {
		p = new Starter();
		c = new Commander();
		f = new Focuser();
	}
	public static void open(FileType fileType, int counter) throws InterruptedException {
		p.setFile("C:/FtpFiles/", fileType, counter);
		p.begin();
	}

	public static boolean focusPhoto() {
		if (f.focusOn(p.getFilePath().getFileName().toString()
				+ " - Windows Photo Viewer")) {
			return true;
		} else if (f.focusOn(FilenameUtils.removeExtension(p.getFilePath()
				.getFileName().toString())
				+ " - Windows Photo Viewer")) {
			return true;
		} else {
			return false;
		}
	}
	public static File getCurrentPhoto() {
		return p.getFile();
	}
	public static File setCurrentVideo() {
		return p.getFile();
	}
	public static File[] getFiles() {
		return p.getFiles();
	}
	public static boolean focusVideo() throws InterruptedException {
		if (!f.focusOn("BS.Player") || !(f.focusOn("Windows Media Player")))
			return false; // Returneaza fals daca fereastra nu e deschisa si
							// iese din functie
		else {
			c.focus();
			return true;
		}
	}

	public void execute(String command) throws AWTException,
			InterruptedException {
		// Receiver.serialPort.close();
		 start();
		/*
		 open(FileType.VIDEO, videoCounter);
    		 Thread.sleep(2000);
    		 c.close();
    		 Thread.sleep(2000);
    		 c.nextVideo();
    		 */
    		 
		 switch (command) {	
		 case " = START":	//Start
				 start();
			 break;
         case " = DOWNLOAD":  //Download
        	 new LoginForm(TransferType.DOWNLOAD).setVisible(true);
                  break;
         case " = UPLOAD":  //Upload
        	 new LoginForm(TransferType.UPLOAD).setVisible(true);
                  break;
         case " = OPEN_PHOTO":  //Open Photo
     		 open(FileType.PHOTO, videoCounter);
                  break;
         case " = NEXT_PHOTO":  //Next Photo
        	 if (focusPhoto()) c.nextPhoto();
                  break;
         case " = PREVIOUS_PHOTO":  //Previous Photo
        	 if (focusPhoto()) c.previousPhoto();
                  break;
         case " = ZOOM_OUT_PHOTO":  //Zoom out Photo
        	 if (focusPhoto()) c.zoomOut();
                  break;
         case " = ZOOM_IN_PHOTO":  //Zoom in Photo
        	 if (focusPhoto()) c.zoomIn();
                  break;
         case " = MINIMIZE":  //Minimize
        	 c.minimize();
                  break;
         case " = OPEN_VIDEO":  //Open Video
     		 open(FileType.VIDEO, videoCounter);
                  break;
         case " = PLAY":  //Play
        	 if (focusVideo()) c.playPause();
                  break;
         case " = PAUSE": //Pause
        	 if (focusVideo()) c.playPause();
        	 	  break;	
         case " = NEXT_VIDEO":  //Next Video
        	// if (focusVideo()) {
        		 c.close();
        		 Thread.sleep(500);
        		 c.nextVideo();
        	 //}
                  break;
         case " = PREVIOUS_VIDEO":  //Previous Video
        	 if (focusVideo()) {
        		 c.close();
        		 Thread.sleep(500);
        		 c.previousVideo();
        	 }
                  break;
         case " = MUTE":  //Mute
        	 if (focusVideo()) c.mute();
                  break;
         case " = VOLUME_UP":  //Volume up
        	 if (focusVideo()) c.louder();
                  break;
         case " = VOLUME_DOWN":  //Volume down
        	 if (focusVideo()) c.quieter();
                  break;    
         case " = FULLSCREEN":  //Fullscreen
        	 if (focusVideo()) c.fullscreen();
                  break;
         case " = CLOSE":  //Close
        	 c.close();
                  break;
         case " = FOCUS_VIDEO":  //Focus Video
        	 focusVideo();
                  break;   
         case " = FOCUS_PHOTO":  //Focus Photo
        	 focusPhoto();
                  break;   
         default:	
        	 System.out.println("Command not recognized");
		 }
		 System.out.println(command);
	}

}
