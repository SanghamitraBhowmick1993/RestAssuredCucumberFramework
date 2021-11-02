package JavaQuestions;

public class StringWordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "thisNaveenAutomationLabsYouTube";
		
		//if small word string is at the beginning
		int c = 0;
		if(Character.isLowerCase(str.charAt(0))){
			c++;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				c++;
			}
		}
		System.out.println(c);
		
		int count2= 0;
		for (int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))){
				count2++;
			}
		}
		System.out.println(count2);

	}



	
}
