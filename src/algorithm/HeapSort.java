package algorithm;

public class HeapSort {
	
	static public void heapify(int[] arr,int index,int size) {
		int left=2*index+1;
		int right = left+1;
		
		int max=index;
		
		if(left<size && arr[left]>arr[max]) {
			max=left;
		}
		
		if(right<size && arr[right]>arr[max]) {
			max=right;
		}
		
		if(max!=index) {
			int temp=arr[index];
			arr[index]=arr[max];
			arr[max]=temp;
			
			heapify(arr, max,size);
			
		}
	}
	
	static public void heapSort(int[] arr) {
		int size=arr.length;
		for(int i=(size-1)/2;i>=0;i--) {
			heapify(arr, i, size);
		}
		/*
		 * for(int i=0;i<arr.length;i++) { System.out.println(arr[i]); };
		 */
		while(size>0) {
			int temp=arr[0];
			arr[0]=arr[size-1];
			arr[size-1]=temp;
			size--;
			heapify(arr,0, size);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {78,23,45,12,34,89,90,20};
		
		HeapSort.heapSort(arr);
		System.out.println("Result");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		};
	}

}
