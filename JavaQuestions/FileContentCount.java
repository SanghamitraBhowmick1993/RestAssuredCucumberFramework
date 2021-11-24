package JavaQuestionsPart3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileContentCount {
	
	static String path ="C:\\Users\\sanbhowmick\\Documents\\createSample.txt";

	public static void main(String[] args) {
		// count total char, words and lines
		int charCount = 0;
		int wordCount = 0;
		int lineCount =0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));			
			String currLine = reader.readLine();
			while(currLine !=null){
				
				lineCount++;
				
				//words:
				String words[] = currLine.split(" ");
				wordCount = wordCount + words.length;
				
				//char:
				for(String word : words){
					charCount = charCount+ word.length();
				}
				currLine = reader.readLine();
			}
			System.out.println("Total lines: " + lineCount);
			System.out.println("Total words: " + wordCount);
			System.out.println("Total chars: " + charCount);

		}		

			 catch (IOException e) {
				e.printStackTrace();
			 }
		

	}

}
