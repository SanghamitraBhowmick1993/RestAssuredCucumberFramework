package JavaQuestions;

public class FibanacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0 1 1 2 3 5 8 13 
		int num = 10;
		int x = 0;
		int y = 1;
		for(int i =1 ; i<=num;i++){
		System.out.println(x);
		int sum = x+y;
		x=y;
		y = sum;
		}
	}

}
