package JavaQuestions;

public class addNumbers {
	//https://www.youtube.com/playlist?list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz

	public static void main(String[] args) {
			/*int a =10;
			int b = 20;			
			int sum = a+b;
			System.out.println("Sum of a and b is :" + sum);*/
		
		int num = 5;
		int sum = 1;
		for(int i=num;i>=1;i--){
			sum = sum* i;
		}
		System.out.println(sum);
}
}
