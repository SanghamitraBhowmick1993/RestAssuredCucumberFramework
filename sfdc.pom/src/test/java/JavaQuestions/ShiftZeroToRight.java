package JavaQuestions;

import java.util.Arrays;

public class ShiftZeroToRight {

	public static void main(String[] args) {
		int i[] = new int[] {1,0,2,0,3,0,9}; //1,2,3,9,0,0,0
		System.out.println(Arrays.toString(shiftZeroToRight(i)));
	}
	public static int[] shiftZeroToRight(int[] a){
		if(a.length ==1){
			return a;
		}
		
		
		int[] newArray = new int[a.length];
		int count = 0;
		for(int num : a){
			if(num !=0){ //non zero numbers
				newArray[count] = num;
				count++;
			}
		}
		return newArray;
	}

}
