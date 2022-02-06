package algorithm;

public class SelectionSort {
	
	public static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {78,12,45,34,25,30,10};
		SelectionSort.selectionSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}
