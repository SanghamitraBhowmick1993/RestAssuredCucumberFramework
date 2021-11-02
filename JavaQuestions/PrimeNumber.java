package JavaQuestions;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// divisble by 1 and itself, 13,17 and 2 is lowest prime
		int num =13;
		int count = 0;
		if(num > 1){
		for(int i =1;i<=num;i++){
			if(num%i==0){
				count++;
			}
		}
		if(count==2){
			System.out.println(num + " is Prime");
		}
		else{
			System.out.println(num + " is NOT Prime");
		}
		}
		else{
			System.out.println(num + " is not Prime");
		}

}
}
