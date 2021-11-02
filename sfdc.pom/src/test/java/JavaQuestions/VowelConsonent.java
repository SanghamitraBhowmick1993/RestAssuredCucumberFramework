package JavaQuestions;

public class VowelConsonent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// a e i o u
		char ch = 'e';
		if(ch=='a' || ch=='e'||ch=='i'||ch=='o'||ch=='u'){
		System.out.println(ch + " is vowel");
		}
		else{
			System.out.println(ch + " is consonent");

		}
		
		switch(ch){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println(ch + " is vowel");
			break;
			default :
				System.out.println(ch + " is consonent");
				break;

		}

	}

}
