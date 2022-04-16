package JavaQuestionsPart3;

import java.util.Arrays;

public class SecondLargestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		secondLargest(new int[]{3,5,8});

	}
	//3 2 5
	
	public static void secondLargest(int[] input){
		int firstLargest, secondLargest;
		if(input[0] > input[1]){
			firstLargest = input[0];
			secondLargest = input[1];
		}
		else{
			firstLargest = input[1];
			secondLargest = input[0];

		}
		for(int i =2;i<input.length;i++){
			if(input[i] >firstLargest ){
				secondLargest = firstLargest;
				firstLargest = input[i];
			}
			else if(input[i] < firstLargest && input[i] > secondLargest){
				secondLargest = input[i];
			}
		}
		System.out.println("Input Array: ");
		System.out.println(Arrays.toString(input));
		System.out.println("Second largest ele is : " + secondLargest);
	}
	
	
	//Approach2
	int arr[]= {10, 20, 25, 63, 96, 57};
		int temp;
	      int size = arr.length;

		
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
		
		System.out.println("second largest : " + arr[size-2]);
	}

}
