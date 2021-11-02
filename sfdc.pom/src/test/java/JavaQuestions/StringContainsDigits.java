package JavaQuestions;

public class StringContainsDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumneric("123A"));

	}
	public static boolean isEmpty(CharSequence cs ){
		return cs == null || cs.length()==0;
	}
	
	public static boolean isNumneric(CharSequence cs){
		if(isEmpty(cs)){
			return false;
		}
		int len = cs.length();
		for(int i =0;i<len;i++){
			if(! Character.isDigit(cs.charAt(i))){
				return false;
			}
		}
		return true;
	}

}
