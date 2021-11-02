package JavaQuestions;

import java.util.Arrays;

public class SortAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ar[] = { "Selenium", "Java", "Python", "Ruby" };
		for (int i = 0; i < ar.length-1; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				// sorting based on length
				// to sort based on alphabet order, use if(ar[i].compareTo(ar[j])>0)
				if((ar[i].length())>(ar[j].length())){
					String temp = ar[i]; 
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(ar));

	}

}
