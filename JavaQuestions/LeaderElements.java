package JavaQuestionsPart3;

public class LeaderElements {

	public static void main(String[] args) {
		// 76 56 45 22 23 8
		int num[] ={76, 56, 45, 22, 23, 8};
		findLeaders(num);

	}
	
	public static void findLeaders(int num[]){
		
		if(num.length==0){
			return;
		}
		if(num.length==1){
			System.out.println(num[0]);
			return;
		}
		
		int max = num[num.length-1];
		
		System.out.print(max + " ");
		
		for(int i = num.length-2; i >=0;i--){
			
			if(num[i] > max){
				
				System.out.print(num[i] + " ");
				
				max = num[i];
			}
		}
		
		
		
		
	}

}
