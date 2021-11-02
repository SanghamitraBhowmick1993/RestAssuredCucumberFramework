package JavaQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateElementsInJavaArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] ={"Java","Python","Java","Ruby"};
		for(int i =0;i<names.length;i++){
			for(int j=i+1;j<names.length;j++){
				if(names[i]==names[j]){
					//System.out.println("Dup Ele is : " + names[i]);
				}
			}
		}
		//System.out.println("********************");
		
		//Using Hashset
		Set<String> namesList = new HashSet<String>();
		for(String name: names){
			if(namesList.add(name)==false){
				//System.out.println("Dup Ele is : " + name);
			}
		}
		//System.out.println("********************"); O(2n)
		
		Map<String,Integer> storeMap = new HashMap<String,Integer>();
		for(String name : names){
			Integer count = storeMap.get(name);
			if(count==null){
				storeMap.put(name, 1);
			}
			else{
				storeMap.put(name, storeMap.get(name)+1);

			}}
			//get the values
			Set<Entry<String, Integer>> entrySet =	storeMap.entrySet();
			for(Entry<String, Integer> entry : entrySet){
				if(entry.getValue()>1){
					System.out.println("Dup ele is : " + entry.getKey());
				
			}
		}

	}

}
