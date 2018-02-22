package pshc.rnd.exec;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ExecuteTest {
	public static void main(String args[]) {
		// 1 file open
		File f = new File("C:\\Users\\Jin\\Desktop/putty.exe");
		try {
		    Desktop.getDesktop().open(f);
		} catch (IOException e) {
		    e.printStackTrace();
		}
//		// 2 file open in cmd
//		try {
//			Runtime runtime = Runtime.getRuntime();
//			runtime.exec("cmd /c C:\\Users\\Jin\\Desktop/putty.exe");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}
