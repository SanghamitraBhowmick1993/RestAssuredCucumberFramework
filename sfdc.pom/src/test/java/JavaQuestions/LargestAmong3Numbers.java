package JavaQuestions;

public class LargestAmong3Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 600;
		int y = 500;
		int z = 300;
		if((x>y) && (x>z)){
			System.out.println("x is greater number " + x);
		}
		else if((y>z) && (y>x)){
			System.out.println("y is greater number " + y);

		}
		else{
			System.out.println("z is greater number " + z);

		}

	}

}
