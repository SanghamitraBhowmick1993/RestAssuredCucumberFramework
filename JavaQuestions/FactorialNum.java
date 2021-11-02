package JavaQuestions;

public class FactorialNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//!5 = 5*4*3*2*1 = 120
		getFactorial(5);
		
	}
	public static void getFactorial(int num){
		int fact = 1;
		for(int i =1;i<=num;i++){
			fact = fact *i;
		}
		System.out.println("Fact of " + num + " is : " + fact);
	}

}
