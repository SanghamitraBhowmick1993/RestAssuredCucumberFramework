package JavaQuestionsPart3;

import java.util.HashSet;
import java.util.Set;
//https://www.programiz.com/java-programming/examples/compute-all-string-permutation
public class PermutationsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutations("abc"));

	}
	
	public static Set<String> getPermutations(String str){
		
		Set<String> permutations = new HashSet<String>(); //create set to avoid dup permu
		//check if str is null
		if(str==null){
			return null;
		}
		else if(str.length()==0){
			permutations.add("");
			return permutations;
		}
		//get first char
		char first = str.charAt(0);
		//get remaining substr
		String sub = str.substring(1);
	    // make recursive call to getPermutation()
		Set<String> words = getPermutations(sub);
	    // access each element from words
		for(String strNew : words){
			for(int i =0; i<=strNew.length();i++){
		        // insert the permutation to the set
				permutations.add(strNew.substring(0, i) + first + strNew.substring(i));

			}
		}
		return permutations;

		
	}

}
