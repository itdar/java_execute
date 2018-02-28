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
			ProcessBuilder processBuilder = new ProcessBuilder(
					"cmd","/c", "C:\\Users\\Jin\\Desktop/putty.exe");
			processBuilder.start();
					
			Thread.sleep(1000);
			
			Runtime runtime1 = Runtime.getRuntime();
			Process process1 = runtime1.exec("wmic process where name=\"putty.exe\" get processid");
//			Process process = runtime1.exec("tasklist");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(process1.getInputStream()));
		    String tempString = "";
			String line;
			while ((line = br.readLine()) != null) {
				tempString += line;
			}
			tempString = tempString.replace(" ", "");
		    System.out.println(tempString);
		    
		    byte[] bytes = tempString.getBytes();
		    String resultString = "";
		    for (int i = 0; i < bytes.length; i++) {
		    	if (bytes[i] > 47 && bytes[i] < 58) {
		    		resultString += Character.toString((char)bytes[i]);
		    	}
		    	System.out.println(bytes[i]);
		    }
		    System.out.println(resultString);
		    
		    br.close();
		    
//		    Thread.sleep(2000);
		    
//			String tempPID = "4104";
//			runtime1.exec("cmd /c TASKKILL /F /PID " + tempPID);
			
//			Thread.sleep(10000);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		cmd /c TASKKILL /F /PID ${processId}
//		wmic process where name="putty.exe" get processid | MORE +1
		
		
	}
}
