package JavaQuestions;

public class PowerOfNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3^4 = 81
		int base =3;
		int exponent = 4;
		long result = 1;
		while(exponent!=0){
			result = result * base;
			exponent--;
		}
		System.out.println(result);
	}

}
