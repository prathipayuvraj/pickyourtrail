package pickyourtrail;

import java.util.Scanner;

public class MinimumSum {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the lenght of the array:");
		int length = scanner.nextInt();
		System.out.println("Enter the array elements");
		int[] dataArray = new int[length];
		for(int i=0; i<length;i++) {
			dataArray[i] = scanner.nextInt();
		}
		int minimumSum = getMinimumUniqueSum(length,dataArray);
		System.out.println("The sum of unique elements is: "+ minimumSum);
	}

	private static int getMinimumUniqueSum(int length, int[] dataArray) {
		//sort the array in ascending order
		int[] sortedArray = sort(dataArray);
		
		int sum = sortedArray[0];
		int current = sortedArray[0]; 
		
        for (int index = 1; index < length; index++) { 
        	//if duplicate value is present, increment accordingly
            if (sortedArray[index] <= current) { 
            	current = current + 1; 
                sum = sum + current; 
            } 
            //No duplication, no incrementation
            else { 
                sum = sum + sortedArray[index]; 
                current = sortedArray[index]; 
            } 
        } 
        return sum; 
	}

	private static int[] sort(int[] dataArray) {
		int temp;
		for (int i = 0; i < dataArray.length; i++) 
        {
            for (int j = i + 1; j < dataArray.length; j++) 
            {
                if (dataArray[i] > dataArray[j]) 
                {
                    temp = dataArray[i];
                    dataArray[i] = dataArray[j];
                    dataArray[j] = temp;
                }
            }
        }
		return dataArray;
	}

}
