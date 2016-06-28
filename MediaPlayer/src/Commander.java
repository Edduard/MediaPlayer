import java.awt.AWTException;
import java.awt.Robot;

import com.sun.glass.events.KeyEvent;

public class Commander {

	Robot R;

	public Commander() throws AWTException {
		R = new Robot();
	}

	public void nextPhoto() {
		R.keyPress(KeyEvent.VK_RIGHT);
		R.keyRelease(KeyEvent.VK_RIGHT);
		// maximize();
	}

	public void previousPhoto() {
		R.keyPress(KeyEvent.VK_LEFT);
		R.keyRelease(KeyEvent.VK_LEFT);
		// maximize();
	}
	public void zoomIn() {
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_ADD);
		R.keyRelease(KeyEvent.VK_ADD);
		R.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void zoomOut() {
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_MINUS);
		R.keyRelease(KeyEvent.VK_MINUS);
		R.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void close() {
		R.keyPress(KeyEvent.VK_ALT);
		R.keyPress(KeyEvent.VK_F4);
		R.keyRelease(KeyEvent.VK_F4);
		R.keyRelease(KeyEvent.VK_ALT);
	}

	public void playPause() {
		R.keyPress(KeyEvent.VK_SPACE);
		R.keyRelease(KeyEvent.VK_SPACE);
	}

	public void stop() {
		R.keyPress(KeyEvent.VK_V);
		R.keyRelease(KeyEvent.VK_V);
	}

	public void shuffle() {
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_H);
		R.keyRelease(KeyEvent.VK_H);
		R.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void fullscreen() {
		R.keyPress(KeyEvent.VK_F);
		R.keyRelease(KeyEvent.VK_F);
	}

	public void minimize() {
		R.keyPress(KeyEvent.VK_WINDOWS);
		R.keyPress(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_WINDOWS);
	}

	public void maximize() {
		R.keyPress(KeyEvent.VK_WINDOWS);
		R.keyPress(KeyEvent.VK_UP);
		R.keyRelease(KeyEvent.VK_UP);
		R.keyRelease(KeyEvent.VK_WINDOWS);
	}

	public void focus() {
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_3);
		R.keyRelease(KeyEvent.VK_3);
		R.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void louder() {
		R.keyPress(KeyEvent.VK_UP);
		R.keyRelease(KeyEvent.VK_UP);
	}

	public void quieter() {
		R.keyPress(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_DOWN);
	}

	public void mute() {
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_M);
		R.keyRelease(KeyEvent.VK_M);
		R.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void nextVideo() {
		Executer.videoCounter++;
		if(Executer.videoCounter > Executer.getFiles().length - 1) Executer.videoCounter = 0;
		
		try {
			Executer.open(FileType.VIDEO, Executer.videoCounter);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void previousVideo() {
		if(Executer.videoCounter-- < 0) {
			Executer.videoCounter = Executer.getFiles().length - 1;
		}
		else Executer.videoCounter--;
		try {
			Executer.open(FileType.VIDEO, Executer.videoCounter);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
