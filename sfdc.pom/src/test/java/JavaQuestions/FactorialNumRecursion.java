package JavaQuestions;

public class FactorialNumRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiplyNumbers(5));

	}
	public static int multiplyNumbers(int num){
		if(num>=1){
			return num* (multiplyNumbers(num-1));
		}
		else{
			return 1;
		}
	}

}
