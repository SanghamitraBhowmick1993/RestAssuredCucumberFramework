package JavaQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="Selenium";
		char[] words = s.toCharArray();
		Map<Character,Integer> wordCount = new HashMap<Character,Integer>();
		for(Character word: words){
			if(wordCount.containsKey(word)){
				wordCount.put(word, wordCount.get(word)+1);
			}
			else{
				wordCount.put(word, 1);
			}
		}
		//Iterating the map		
		Set<Entry<Character, Integer>> setCount = wordCount.entrySet();
		for(Entry<Character, Integer> set : setCount){
			if(set.getValue()>1){
				System.out.println(set.getKey() + " :: " + set.getValue());
			}
		}
	}

}
