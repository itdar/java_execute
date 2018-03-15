package pshc.rnd.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteTest {
	public static void main(String args[]) throws Exception {
//		// 1 file open
//		File f = new File("C:\\Users\\Jin\\Desktop/putty.exe");
//		try {
//		    Desktop.getDesktop().open(f);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
		// 2 file open in cmd
		try {
			//Execute application
			ProcessBuilder processBuilder = new ProcessBuilder(
					"cmd","/c", "C:\\Users\\Jin\\Desktop/putty.exe");
			processBuilder.start();
					
			Thread.sleep(1000);
			
			//Find process id from task manager
			Runtime runtime1 = Runtime.getRuntime();
			Process process1 = runtime1.exec("wmic process where name=\"putty.exe\" get processid");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(process1.getInputStream()));
		    String tempString = "";
			String line;
			while ((line = br.readLine()) != null) {
				tempString += line;
			}
			br.close();
		    
		    byte[] bytes = tempString.getBytes();
		    String resultString = "";
		    boolean isDone = false;
		    for (int i = 0; i < bytes.length && !isDone; i++) {
		    	if (bytes[i] > 47 && bytes[i] < 58) {
		    		resultString += Character.toString((char)bytes[i]);
		    	} else if (i > 0 && bytes[i-1] > 47 && bytes[i-1] < 58) {
		    		isDone = true;
		    	}
		    }
		    
		    System.out.println(resultString);
		    
		    
		    
		    Thread.sleep(2000);
		    
			runtime1.exec("cmd /c TASKKILL /F /PID " + resultString);
			
			Thread.sleep(10000);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		cmd /c TASKKILL /F /PID ${processId}
//		wmic process where name="putty.exe" get processid | MORE +1
		
		
	}
}
