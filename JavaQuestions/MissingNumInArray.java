package JavaQuestions;

public class MissingNumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers [] ={1,2,3,5};
		int sum =0;
		for(int i=0;i<numbers.length;i++){
			sum = sum + numbers[i];
		}
		System.out.println(sum);
		
		int total_sum = 0;
		for(int j=1;j<=5;j++){
			total_sum = total_sum+j;
		}
		System.out.println(total_sum);
		System.out.println("Missing num is : " + (total_sum-sum));
	}
	
}
