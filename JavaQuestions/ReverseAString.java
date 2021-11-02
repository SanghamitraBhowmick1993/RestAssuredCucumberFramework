package JavaQuestions;

public class ReverseAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Selenuim";
		int len = s.length();
		String rev = "";
		for(int i = len-1;i>=0;i--){
			rev = rev + s.charAt(i);
		}
		System.out.println(rev);
		
		//StringBuffer
		StringBuffer sf = new StringBuffer(s);
		System.out.println(sf.reverse());
	
		
			

	}

}
