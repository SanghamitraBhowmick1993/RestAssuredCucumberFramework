package JavaQuestions;

public class NaturalNumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 100;
		int sum =0;
		int sum1 =0;
		//1+2+3+4....100 =>5050
		for(int i =1;i<=num;i++){
			sum = sum+i;
		}
		System.out.println("Sum is " + sum);
		
		System.out.println("*************");
		
		int k =1;
		while(k<=num){
			sum1 = sum1+k;
			k++;
		}
		System.out.println("Sum is " + sum1);


	}

}
