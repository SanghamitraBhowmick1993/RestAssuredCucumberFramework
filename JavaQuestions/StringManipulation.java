package JavaQuestions;

public class StringManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "The rains have started here";
		String str1 = "The rains Have started here";

		
		System.out.println(str.length());
		
		System.out.println(str.charAt(5));
		
		System.out.println(str.indexOf('s'));
		
		System.out.println(str.indexOf('s', str.indexOf('s')+1));
		
		System.out.println(str.indexOf("have"));
		
		System.out.println(str.indexOf("hello"));
		
		System.out.println(str.equalsIgnoreCase(str1));
		
		System.out.println(str.substring(0, 9));
		
		String s  = "   Hello World   ";
		System.out.println(s.trim());
		System.out.println(s.replace(" ", ""));
		
		String test = "Hello_world_test_selenium";
		String testVal[] =test.split("_");
		for(int i =0;i<testVal.length;i++){
			System.out.println(testVal[i]);
		}

		String s2 ="cares";
		System.out.println(s2.concat(s));


	}

}
