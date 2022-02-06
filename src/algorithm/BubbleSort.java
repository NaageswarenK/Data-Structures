package algorithm;

public class BubbleSort {
	
	public static void bubbleSort(int[] arr) {
		int flag=0;
		for(int i=0;i<arr.length-1;i++) {
			System.out.println(i);
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=1;
				}
				
			}
			if(flag==0) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {5,6,36,67,90,95};
		
		BubbleSort.bubbleSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}
