package JavaQuestions;

public class RemoveJunkChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "$#**testing&8123 checkString@@";
		s=s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);

	}

}
