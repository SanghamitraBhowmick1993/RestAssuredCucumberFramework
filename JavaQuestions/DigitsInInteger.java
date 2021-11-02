package JavaQuestions;

public class DigitsInInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num =1234;
		int count = 0;
		while(num!=0){
			num =num/10;
			++count;
		}
		System.out.println("Digits in num is : " + count);
	}

}
