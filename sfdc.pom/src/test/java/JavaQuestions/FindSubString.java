package JavaQuestions;

public class FindSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSubString("Naveen automation labs","labs"));
		System.out.println(isSubString1("Naveen automation labs","labs"));


	}
	public static boolean isSubString(String main, String sub){
		return main.contains(sub);
	}
	public static boolean isSubString1(String main, String sub){
		return main.indexOf(sub) !=-1;
	}
}
