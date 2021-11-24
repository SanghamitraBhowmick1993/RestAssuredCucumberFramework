package JavaQuestionsPart3;


public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String newString = "       This is java     problem solution       ";
		
		String noWhiteSpace ="";
		
		for(int i = 0;i<newString.length();i++){
			if((newString.charAt(i)!= ' ') && (newString.charAt(i)!= '\t')){
				noWhiteSpace = noWhiteSpace + newString.charAt(i);
			}
		}
		System.out.println(noWhiteSpace);
		
	//	System.out.println(newString.trim());
		
	//  System.out.println(newString.replaceAll("\\s+", "")); //  \\s+ --> faster performance
		
	//  System.out.println(StringUtils.deleteWhitespace(newString));
		
		
		String str = "This   is a new Array      ";
		String[] newArr = str.split("\\s");
		StringBuffer remString = new StringBuffer();
		for(String arr : newArr){
			remString.append(arr);
		}
		System.out.println(remString);

		
		
		
	}

}
