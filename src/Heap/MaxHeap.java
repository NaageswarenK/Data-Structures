package Heap;

public class MaxHeap {
	
	private int size;
	private int capacity;
	private int[] heap;
	
	public void buildHeap(int size) {
		this.size=size;
		capacity=0;
		heap = new int[size];
		//heap[0]=Integer.MAX_VALUE;
			
	}
	
	public int deleteMax() {
		int value=heap[0];
		heap[0]=heap[capacity-1];
		capacity=capacity-1;
		heapify(0);
		return value;
	}
	
	public void insert(int value) {
		if(capacity == size) {
			return;
		}
		else {
			
			int temp=capacity;
			heap[temp]=value;
			while(heap[parent(temp)]<heap[temp]) {
				int swaptemp=heap[parent(temp)];
				heap[parent(temp)]=heap[temp];
				heap[temp]=swaptemp;
				temp=parent(temp);
			}
			capacity=capacity+1;
		}
	}
	
	public int parent(int index) {
		return (index-1)/2;
	}
	
	public void heapify(int index) {
		int left=2*index+1;
		int right = left+1;
		
		int max=index;
		
		if(left<capacity && heap[left]>heap[max]) {
			max=left;
		}
		
		if(right<capacity && heap[right]>heap[max]) {
			max=right;
		}
		
		if(max!=index) {
			int temp=heap[index];
			heap[index]=heap[max];
			heap[max]=temp;
			
			heapify( max);
			
		}
	}
	
	public void printHeap() {
		for(int i=0;i<capacity;i++) {
			System.out.println(heap[i]);
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {20,30,10,40,8,12,70};
		
		MaxHeap heap=new MaxHeap();
		heap.buildHeap(10);
		//heap.buildHeap(arr);
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(40);
		heap.printHeap();
		System.out.println(heap.deleteMax());
		heap.printHeap();
		System.out.println(heap.deleteMax());
		heap.printHeap();
		//heap.printHeap(arr);
	}

}
