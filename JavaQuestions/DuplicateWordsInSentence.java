package JavaQuestionsPart3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hi, I am Sang and I am a programmer";
		
		String words[] = str.split("\\W");
		Map<String,Integer> wordMap = new HashMap<String,Integer>();
		for(String word : words){
			if(wordMap.containsKey(word)){
				wordMap.put(word, wordMap.get(word)+1);
			}
			else{
				wordMap.put(word, 1);
			}
		}
		
		//Iterating the map
		Set<String> wordSet = wordMap.keySet();
		for(String word : wordSet){
			if(wordMap.get(word)>1){
				System.out.println(word);
			}
		}
	}

}
