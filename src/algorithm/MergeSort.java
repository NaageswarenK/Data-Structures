package algorithm;

public class MergeSort {
	
	
	static public void merge(int[] arr,int start,int mid,int end) {
		int[] temp=new int[end-start+1];
		
		int i=start;
		int j=mid+1;
		
		int k=0;
		
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j]) {
				temp[k]=arr[i];
				i++;
				k++;
			}
			else {
				temp[k]=arr[j];
				j++;
				k++;
			}
		}
		
		while(i<=mid) {
			temp[k]=arr[i];
			k++;
			i++;
		}
		while(j<=end) {
			temp[k]=arr[j];
			k++;
			j++;
		}
		
		k=0;
		for(i=start;i<=end;i++) {
			arr[i]=temp[k];
			k++;
		}
	}
	
	static public void mergeSort(int[] arr,int start,int end) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {78,23,45,12,34,89,90,20};
		
		MergeSort.mergeSort(arr, 0, arr.length-1);
		System.out.println("Result");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		};
	}
	
	

}
