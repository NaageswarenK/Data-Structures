package algorithm;

public class QuickSort {
	
	static public int partition(int[] arr,int start,int end) {
		int pIndex=start;
		int pivot=end;
		
		for(int i=start;i<=end;i++) {
			if(arr[i]<arr[pivot]) {
				int temp=arr[i];
				arr[i]=arr[pIndex];
				arr[pIndex]=temp;
				pIndex++;
			}
		}
		int temp=arr[pIndex];
		arr[pIndex]=arr[pivot];
		arr[pivot]=temp;
		return pIndex;
		
	}
	
	static public void quickSort(int[] arr,int start,int end) {
		if(start<end) {
			int pIndex=partition(arr,start,end);
			quickSort(arr,start,pIndex-1);
			quickSort(arr, pIndex+1, end);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {78,23,45,12,34,89,90,20};
		
		QuickSort.quickSort(arr, 0, arr.length-1);
		System.out.println("Result");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		};
	}

}
