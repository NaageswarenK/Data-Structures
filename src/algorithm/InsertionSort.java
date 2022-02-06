package algorithm;

public class InsertionSort {
	
	static public void insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int index=i;
			int value=arr[index];
			while(index>0 && arr[index-1]>value) {
				arr[index]=arr[index-1];
				//arr[index-1]=value;
				
				index--;
				
			}
			arr[index]=value;
			
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {78,23,45,12,34,89,90,20};
		
		InsertionSort.insertionSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		};
	}

}
