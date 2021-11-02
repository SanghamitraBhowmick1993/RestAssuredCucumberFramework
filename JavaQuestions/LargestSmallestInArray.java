package JavaQuestions;

import java.util.Arrays;

public class LargestSmallestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[]={5,7,200,6,0,-3};
		
		int largest = numbers[0];
		int smallest = numbers[0];
		
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]>largest){
				largest = numbers[i];
			}
			else
				if(numbers[i]<smallest){
					smallest = numbers[i];
			}
				
			}
		System.out.println("given array is : " + Arrays.toString(numbers) );
		System.out.println("Largest num is : " + largest);
		System.out.println("Smallest num is : " + smallest);
		}
		

	}


