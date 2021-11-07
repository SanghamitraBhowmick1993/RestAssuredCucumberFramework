package JavaQuestionPart2;

public class StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="123";
		System.out.println(StringToInteger(s)+1);
		System.out.println(covertToInteger(s)+1);

		
		//int i = Integer.parseInt(s);
		//System.out.println(i+10);
	}
	
	public static int covertToInteger(String str){
		
		if(str.length()==1){
			
			return (int)str.charAt(0)-48;
		}
		
		char ch[] = str.toCharArray();
		int sum = 0;
		int zeroAsc = (int)'0';
		for(int i = 0 ; i<ch.length;i++){
			int asci = (int)ch[i];
			sum = sum * 10 + (asci - zeroAsc);
			
		}
		return sum;
		
	}
	
	public static int StringToInteger(String str){
		
		int num = 0;
		int len = str.length();
		
		for(int i =0; i <len ; i++){
			
			// formula
			num = num *10 + ((int)str.charAt(i) - 48); // convert to ASCII
		}
		return num;
	}

}
