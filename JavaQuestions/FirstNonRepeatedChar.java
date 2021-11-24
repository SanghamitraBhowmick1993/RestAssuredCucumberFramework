package JavaQuestionsPart3;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "teeter";
		char[] words = str.toCharArray();
		for(char word : words){
			if(str.indexOf(word) == str.lastIndexOf(word)){
				System.out.println("First non repeated word :" + word);
			}
		}
	}

}
