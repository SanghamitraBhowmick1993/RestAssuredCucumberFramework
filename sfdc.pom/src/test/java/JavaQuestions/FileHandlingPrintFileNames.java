package JavaQuestions;

import java.io.File;
import java.util.Arrays;

public class FileHandlingPrintFileNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathh ="C:\\Users\\sanbhowmick\\Documents";
		File file = new File(pathh);
		File downloadDir[] = file.listFiles();
		Arrays.sort(downloadDir);
		
		for(File e : downloadDir){
			if(e.isFile()){
				System.out.println("File : " + e.getName() + " " + e.getAbsolutePath());
			}
			else if(e.isDirectory()){
				System.out.println("Dir : " + e.getName() + " " + e.getAbsolutePath());
			}
			else{
				System.out.println("Not known : " + e.getName() + " " + e.getAbsolutePath());
			}
		}

	}

}
