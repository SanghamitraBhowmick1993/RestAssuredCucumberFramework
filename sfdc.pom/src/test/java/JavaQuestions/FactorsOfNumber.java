package JavaQuestions;

public class FactorsOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10 = 1 2 5 10
		int num = 10;
		for(int i =1;i<=num;i++){
			if(num% i==0){
				System.out.print(i + " ");
			}
		}

	}

}
