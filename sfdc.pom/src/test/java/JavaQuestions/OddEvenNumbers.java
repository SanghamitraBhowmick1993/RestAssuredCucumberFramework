package JavaQuestions;

import java.util.Scanner;

public class OddEvenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter a number");
		int num = sc.nextInt();
		if(num % 2 ==0){
			System.out.println("Number is even " + num);
		}
		else{
			System.out.println("Number is odd " + num);
		}

	}

}
