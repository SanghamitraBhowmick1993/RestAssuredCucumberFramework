package JavaQuestions;

public class SwaptwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		System.out.println("Before swap" + " a=" + a+ " b=" + b);
		/*
		int temp;
		temp = a; //temp = 10
		a = b; // a=20
		b = temp; //b=10
		
		System.out.println("After swap" + " a=" + a+ " b=" + b);*/
		System.out.println("*********************");
		//without temp
		
		a= a-b;
		b = a+b;
		a= b-a;
		System.out.println("After swap" + " a=" + a+ " b=" + b);


		
			

	}

}
