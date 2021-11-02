package JavaQuestions;

public class PallindromeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 121;
		 int rev = 0;
		 int org_num=num ;
		 
		 while(num!=0){
			int n =  num%10;
			rev = rev*10 + n;
			num = num/10;
		 }
		 if(org_num==rev){
				System.out.println(org_num + " is pallindrome");
			}else{
				System.out.println(org_num + " is NOT pallindrome");
			}
		 
	
	

}
}