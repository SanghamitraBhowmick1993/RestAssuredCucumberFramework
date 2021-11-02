package JavaQuestions;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//153 = (1*1*1) + (5*5*5)+(3*3*3) = 153
		int num = 153;
		int temp = num;
		int r , sum =0;
		
		while(num>0){
		r = num%10;
		num = num/10;
		sum = sum + r*r*r;
		}
		if(temp ==sum)
			System.out.println(temp + " is an Armstrong num");
		
		else
			System.out.println(temp + " is NOT an Armstrong num");
		

	}
	
}
