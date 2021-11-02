package JavaQuestions;

public class OccuranceOfCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getCharCount("I love coding",'o');
		
	}
	
	public static void getCharOccurance(String str, Character val){
		int count = 0;
		for(Character ch : str.toCharArray()){
			if(ch==val){
				count++;
			}
			
		}
		System.out.println(val + " :: " + count);
	}
	
	public static void getCharCount(String str, Character val){
		int count =0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='o'){
				count++;
			}
		}
		System.out.println(val + " :: " + count);

	}

	

}
