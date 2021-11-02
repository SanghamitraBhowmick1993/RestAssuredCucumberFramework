package JavaQuestions;

public class StringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// find length without using .length()
		String str = "testing";
		
		System.out.println(str.toCharArray().length);
		
		System.out.println(str.lastIndexOf(""));
		
		System.out.println(str.split("").length);
		
		//Method
		int count = 0;
		for(Character c : str.toCharArray()){
			count++;
		}

		System.out.println(count);
		
		System.out.println("**********");
		
		System.out.println(getLength("selenium"));
		
		
		
		

	}
	
	//Method
			public static int getLength(String str){
				int i =0;
				try{
				while(true){
					str.charAt(i);
					i++;
				}}
				catch(IndexOutOfBoundsException e){
					return i;
				}
					
			}

}
