package JavaQuestionsPart3;

import java.text.DecimalFormat;

public class ElementPercentage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//upper case = 10%, lower case = 60%, numerics = 20%, special char = 20%
		
		getCharPercentage("Naveen Automations Labs 123 &#$");

	}
	
	public static void getCharPercentage(String str){
		
		int len = str.length();
		
		int upperCaseCount =0;
		int lowerCaseCount =0;
		int digitsCount =0;
		int specialCharCount =0;
		
		for(int i =0; i<len; i++){
			char ch = str.charAt(i);
			
			if(Character.isUpperCase(ch)){
				upperCaseCount++;
			}
			if(Character.isLowerCase(ch)){
				lowerCaseCount++;
			}
			else if(Character.isDigit(ch)){
				digitsCount++;
			}
			else{
				specialCharCount++;	
			}	
			

		}
		
		double upperCasePercentage = (upperCaseCount *100.0)/len;
		double lowerCasePercentage = (lowerCaseCount *100.0)/len;
		double digitsCountPer = (digitsCount *100.0)/len;
		double specialCharCountPer = (specialCharCount *100.0)/len;
		
		System.out.println("In given str : " + str);
		
		DecimalFormat formatter = new DecimalFormat("##.##"); // to format decimals upto two digits
		
		System.out.println("Upper case% : " + formatter.format(upperCasePercentage));
		System.out.println("Lower case% : " + formatter.format(lowerCasePercentage));
		System.out.println("Digit case% : " + formatter.format(digitsCountPer));
		System.out.println("Special char case% : " + formatter.format(specialCharCountPer));


	}

}
