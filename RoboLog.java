package remoteDragRacer;

import java.io.*;
import java.util.Scanner;

public class RoboLog {
	
	DateTime date = new DateTime();
	String filePath = "C:\\Users\\daniel\\EclipseWorkspace\\Maximum EV3\\RoboLogs\\";
	String fileName = date.getDate() + ".txt";
	File output = new File(filePath,fileName);
	BufferedWriter bufferWriter;
	FileWriter fileWriter;
	Scanner input = new Scanner(System.in);
		
	public void createLog(){
		
		try{
			output.createNewFile();
		}
		catch(SecurityException securityException){
			System.out.println("Do not have access to create file.");
			//System.exit(1);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void writeLog(String message){
		System.out.println("writing to log...");
		try {
			fileWriter = new FileWriter(output.getAbsolutePath(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferWriter = new BufferedWriter(fileWriter);
		
		try{
			bufferWriter.write(date.calTime + " " + "||"+" " + message);
			bufferWriter.close();
		}
		catch(IOException bufferException){
			bufferException.getMessage();
		}
		
		
	}
	
	public void closeLog(){
		System.out.println("closing log...");
		input.close();
	}
	
	public void setFilePath(String path){
		this.filePath = path;
	}
	
	public void setFileName(String name){
		this.fileName = name;
	}
	
	public String getFilePath(){
		return filePath;
	}
	
	public String getFileName(){
		return fileName;
	}



}
