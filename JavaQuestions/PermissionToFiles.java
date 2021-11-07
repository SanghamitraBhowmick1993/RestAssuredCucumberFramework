package JavaQuestionPart2;

import java.io.File;

public class PermissionToFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\sanbhowmick\\Documents\\createSample.txt");
		file.setExecutable(true);
		file.setReadable(true);
		file.setWritable(true);
		file.setExecutable(true, true); // owner permission
		System.out.println("Its done....");

	}

}
