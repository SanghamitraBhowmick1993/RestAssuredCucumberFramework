package JavaQuestions;

public class AlphabetPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A
		//A B
		//A B C
		//A B C D
		// ASCII --> A= 65, B=66,C=67,D=68 ASCII--> a=97
		
		int alpha = 97;
		for(int i=0;i<=5;i++){
			for(int j = 0;j<=i;j++){
				System.out.print((char) (alpha+j) + " ");
			}
			System.out.println("");
		}

	}

}
