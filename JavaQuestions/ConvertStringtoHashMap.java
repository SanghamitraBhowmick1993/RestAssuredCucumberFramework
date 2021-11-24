package JavaQuestionsPart3;

import java.util.HashMap;
import java.util.Map;

public class ConvertStringtoHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value= "{first_name = naresh, last_name = kumar, gneder = male}";
		value.substring(1, value.length()-1); // to remove {}
		String keyValuePair[] = value.split(",");
		
		Map<String,String> map = new HashMap<String,String>();
		for(String pair : keyValuePair){
			String entry[] = pair.split("=");
			System.out.println(map.put(entry[0].trim(), entry[1].trim()));
		}
		
		

	}

}




