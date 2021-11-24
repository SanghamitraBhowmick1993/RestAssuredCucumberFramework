package JavaQuestionsPart3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class DuplicateElementsinIntArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] ={1,1,2,2,3,8,7,5,5};
		
		/*for(int i =0;i<ar.length;i++){
			for(int j =i+1; j<ar.length;j++){
				if(ar[i] == ar[j]){
					System.out.println("dups : " + ar[j]);
				}
			}
		}*/
		HashMap<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
		for(int i =0;i<ar.length;i++){
			if(mapCount.containsKey(ar[i])){
				mapCount.put(ar[i], mapCount.get(ar[i]) + 1);
			}
			else{
				mapCount.put(ar[i], 1);
			}
		}
		//Iterating
		Set<Entry<Integer, Integer>> setCount = mapCount.entrySet();
		for(Entry<Integer, Integer> set : setCount){
			if(set.getValue()>1){
				System.out.println(set.getKey() + " :: " + set.getValue());
			}
		}
	}

}
