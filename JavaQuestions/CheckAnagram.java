package JavaQuestionsPart3;

import java.util.Arrays;

public class CheckAnagram {

	public static void main(String[] args) {
		//Listen Silent , Cat Act
		System.out.println(isAnagram("Listen","Silent"));

	}
	
	public static boolean isAnagram(String s1, String s2){
		
		String str1 = s1.replaceAll("\\s", "");
		String str2 = s2.replaceAll("\\s", "");
		
		if(str1.length() != str2.length()){
			return false;
		}

		else{
			char[] c1 = str1.toLowerCase().toCharArray();
			char[] c2 = str2.toLowerCase().toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			return Arrays.equals(c1, c2);

		}
	}
	
	//Approach2
	String s1= "mary";
		String s2 ="army";
		char c1[]=s1.toCharArray();
		char c2[]=s2.toCharArray();

		
		Map<Character,Integer> charMap= new HashMap<>();
		for(char ch : c1) {
			if(charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch)+1);
			
			}
			else {
				charMap.put(ch, 1);
			}
		}
		for(char ch : c2) {
			if(charMap.get(ch)==1) {
				charMap.remove(ch);
			}
			else {
				charMap.put(ch, charMap.get(ch)-1);
				ch--;
			}
		}
		if(charMap.size()==0) {
			System.out.println("Strings are anagram");
		}
		else {
			System.out.println("Strings are not anagram");
		}
	}

}
