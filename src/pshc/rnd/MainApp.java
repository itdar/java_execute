package pshc.rnd;

import java.io.File;

import javax.swing.JFileChooser;

public class MainApp {
	
	public static void main(String args[]) {
		JFileChooser chooser = new JFileChooser();
		
		File file = new File("C:\\Users\\Jin\\Desktop/resultDicom.dcm");
		
	    String fileTypeName = chooser.getTypeDescription(file);   
	    
	    if (fileTypeName.equals("PACSPLUS")) {
	    	System.out.println("File Type = " + fileTypeName);
	    }
	}
}
