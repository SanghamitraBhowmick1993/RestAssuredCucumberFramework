package JavaQuestionsPart3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortIterateArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> countries = new ArrayList<String>(Arrays.asList("India","Japan","Canada"));
		Collections.sort(countries);
		System.out.println(countries);
		
		//ways to iterate an arraylist
		//1. for loop 2.advanced for loop 3. while loop 4. Iterator
		
		//for loop
		List<Integer> al = new ArrayList<Integer>(Arrays.asList(1,5,6,8));

		for(int i =0;i<al.size();i++){
			//System.out.println(al.get(i));
		}
		//advncd for loop
		for(Integer num : al){
			//System.out.println(num);
		}
		//while loop
		int count =0;
		while(al.size()>count){
			//System.out.println(al.get(count));
			count++;
		}
		//Iterator
		Iterator<Integer> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
	

}
