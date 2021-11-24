package JavaQuestionsPart3;

import java.util.HashMap;
import java.util.Set;

public class RepeatNumberCount {

	public static void getDigitCount(long number) {
		if(String.valueOf(number).length() == 1){
			System.out.println(number + " : " + 1);
			return;
		}
			
		HashMap<Long, Integer> digitMap = new HashMap<Long, Integer>();

		while (number != 0) {

			long lastDigit = number % 10;

			if (digitMap.containsKey(lastDigit)) {
				digitMap.put(lastDigit, digitMap.get(lastDigit) + 1);
			} else {
				digitMap.put(lastDigit, 1);
			}
			number = number / 10;
		}

		Set<Long> keys = digitMap.keySet();

		for (Long key : keys) {
			System.out.println(key + " : " + digitMap.get(key));
		}
	}

	public static void main(String[] args) {
		// 121 , 1: 2 , 2: 1
		getDigitCount(121);

	}

}
