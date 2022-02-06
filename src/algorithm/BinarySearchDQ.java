package algorithm;

public class BinarySearchDQ {
	
	public static boolean search(int[] arr,int start,int end,int key) {
		
		if(start < end) {
			int mid=(start+end)/2;
			
			if(arr[mid]==key) {
				return true;
			}
			else if(arr[mid]>key) {
				return search(arr, 0, mid-1, key);
			}
			else if(arr[mid]<key) {
				return search(arr, mid+1, end, key);
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		int[] arr= {12,15,17,20,37,59,80,100,143,170};
		
		System.out.println(BinarySearchDQ.search(arr, 0, arr.length-1,17));
	}

}
