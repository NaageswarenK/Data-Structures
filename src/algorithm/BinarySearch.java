package algorithm;

public class BinarySearch {

	public static Boolean binarySearch(int[] arr, int key, int start, int end) {
		

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key) {
				return true;
			}

			if (arr[mid] < key) {
				start = mid + 1;
			}

			if (arr[mid] > key) {
				end = mid - 1;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr= {12,15,17,20,37,59,80,100,143,170};
		
		System.out.println(BinarySearch.binarySearch(arr, 200, 0, arr.length-1));
	}

}
