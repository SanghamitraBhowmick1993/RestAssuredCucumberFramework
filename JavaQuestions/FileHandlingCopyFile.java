package JavaQuestions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandlingCopyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copyFile();
		
	}
		public static void copyFile(){
			File file = new File("C:\\Users\\sanbhowmick\\Documents\\sample.pdf");
			File outPutFile = new File("C:\\Users\\sanbhowmick\\Documents\\sampleCpoyFile.pdf");
			
			FileInputStream fileinputStream = null;
			FileOutputStream fileoutputStream = null;
			
			try {
				fileinputStream = new FileInputStream(file);
				fileoutputStream = new FileOutputStream(outPutFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				System.out.println(fileinputStream.available());
			} catch (IOException e) {
				e.printStackTrace();
			}
			int i =0;
			try {
				while((i=fileinputStream.read()) != -1){
					fileoutputStream.write(i);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				//close the stream
				if(fileinputStream != null){
					try {
						fileinputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(fileoutputStream != null){
					try {
						fileoutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
}
