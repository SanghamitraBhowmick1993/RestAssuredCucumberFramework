package JavaQuestionsPart3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MaxWordCountInFile {
	static String path ="C:\\Users\\sanbhowmick\\Documents\\createSample.txt";

	public static void main(String[] args) {
		
		HashMap<String,Integer> wordMap = new HashMap<String,Integer>();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			try {
				String currentLine = reader.readLine();
				while(currentLine !=null){
					String words[] = currentLine.toLowerCase().split(" ");
					
					for(String word : words){						
							
						if(wordMap.containsKey(word)){
							wordMap.put(word, wordMap.get(word)+1);
						}
						else{
							wordMap.put(word, 1);
						}
					}
					 currentLine = reader.readLine();
				}
			
			}catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Iterate and Print the map
		Set<Entry<String,Integer>> sets = wordMap.entrySet();
		
		for(Entry<String, Integer> set : sets){
			System.out.println(set.getKey() + "::" + set.getValue());
		}
		
	}

}
