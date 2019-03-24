package pickyourtrail;

import java.util.Scanner;

public class CountingPairs {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array length");
		int length = scanner.nextInt();
		int[] numberArray = new int[length];
		for(int i=0;i<length;i++) {
			numberArray[i] = scanner.nextInt();
		}
		System.out.println("Enter the value of k");
		int checkValue = scanner.nextInt();
		int count = getUniquePairCount(length,numberArray,checkValue);
		System.out.println("The number of such unique pairs is: " + count);
	}

	private static int getUniquePairCount(int length, int[] numberArray, int checkValue) {
		int[] sortedArray = sort(numberArray);
		int count = 0;
		for (int i = 0; i < length - 1; i++) 
            if (binarySearch(sortedArray, i + 1, length - 1, 
            		sortedArray[i] + checkValue) != -1) 
                count++; 
  
        return count;
	}
	
	private static int binarySearch(int arr[], int low,  int high, int x) { 
		if (high >= low) { 
			int mid = low + (high - low) / 2;			
			if (x == arr[mid]) {
				return mid; 
			}
			if (x > arr[mid]) {
				return binarySearch(arr, (mid + 1), 
	                       high, x);
			}else {
				return binarySearch(arr, low,  
		                 (mid - 1), x);
			}
		}
            return -1; 
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
