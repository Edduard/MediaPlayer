import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.W32APIOptions;

public class Focuser {

	public interface User32 extends W32APIOptions {

		User32 instance = (User32) Native.loadLibrary("user32", User32.class,
				DEFAULT_OPTIONS);

		boolean ShowWindow(HWND hWnd, int nCmdShow);

		boolean SetForegroundWindow(HWND hWnd);

		HWND FindWindow(String winClass, String title);

		int SW_SHOW = 1;

	}

	public boolean focusOn(String window) {
		User32 user32 = User32.instance;
		HWND hWnd = user32.FindWindow(null, window); // Verifica daca window
														// este deja
														// deschisa(path-ul e
														// correct)
		if (hWnd == null) {
			System.out
					.println("Path is not correct or the process is not opened!");
			return false;
		} else {
			// user32.ShowWindow(hWnd, User32.SW_SHOW);
			user32.SetForegroundWindow(hWnd);
			return true;
		}
	}
	

}