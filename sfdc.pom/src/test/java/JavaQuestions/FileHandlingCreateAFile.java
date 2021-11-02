package JavaQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingCreateAFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\sanbhowmick\\Documents\\createSample.txt";
		
		//1. Using file
		File file = new File(path);
		
		try {
			boolean flag = file.createNewFile();
			if(flag){
				System.out.println("file is created");
			}
			else{
				System.out.println("file is already present...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//2. File o/p stream with Scanner
		try {	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file name with path: ");
		String fileName = sc.nextLine();
		
		FileOutputStream fos = new FileOutputStream(fileName, true);
		
		System.out.println("ENter the file content: ");
		String content = sc.nextLine();
		byte b[] = content.getBytes();
		
		try {
			fos.write(b);
			fos.close();
			System.out.println("File is saved on given location");
		} catch (IOException e) {
			System.out.println("Some expection is coming..");

			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
