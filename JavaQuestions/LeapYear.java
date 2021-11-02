package JavaQuestions;

public class LeapYear {

	public static void main(String[] args) {
		//year divisble by 4 for all century year --ending with 00
		//century year is a leap year when it is divisble by 400
		//1900 -- not a leap yr
		//2012 - leap yr
		
		int year = 2012;
		boolean leap = false;
		if(year % 4 == 0){
			if(year % 100 ==0){
				if(year % 400==0){
					leap = true;
				}
				else{
					leap = false;
				}
				
			}
			leap = true;
		}
		else{
			leap = false;
		}
		if(leap){
			System.out.println(year + " is a leap year");
		}
		else{
			System.out.println(year + " is a NOT a leap year");

		}

	}

}
