package JavaQuestionsPart3;

import java.util.HashSet;

public class StringHasUniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = false;
		String str = "Alive swum";
		char words[] = str.toCharArray();
		HashSet<Character> charSet = new HashSet<Character>();
		for(Character word : words){
			if(charSet.add(word)== false){
				break;
			}
			System.out.println(result);


		}
		


	}

}
