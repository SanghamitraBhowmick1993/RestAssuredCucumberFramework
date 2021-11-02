package JavaQuestions;

public class NumIsSumOf2Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//  34 = 3 + 31 , 5+29, 11+23, 17+17
		//System.out.println(checkPrimeNum(13));
		int num = 34;
		boolean flag = false;
		for(int i = 2;i<=num/2;i++){
			if(checkPrimeNum(i)){
				if(checkPrimeNum(num-i)){
					System.out.println(num + " = " + i + " + " + (num-i));
					flag = true;
				}
			}
		}
		if(!flag){
			System.out.println(num + "can not be expressed as sum of 2 numbers");
		}

	}
	public static boolean checkPrimeNum(int num){
		boolean isPrime = true;
		for(int i = 2; i<=num/2;i++){
			if(num% i ==0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

}
