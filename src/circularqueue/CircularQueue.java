package circularqueue;

public class CircularQueue {
	
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	
	public CircularQueue(int size) {
		this.size=size;
		queue=new int[size];
		front=-1;
		rear=-1;
	}
	
	public void enqueue(int value) {
		if(front==-1 && rear==-1) {
			front =0;
			rear=0;
			queue[rear]=value;
		}
		else if((rear+1)%size==front){
			System.out.println("Queue is full");
		}else {
			rear=(rear+1)%size;
			queue[rear]=value;
		}
		
	}
	
	public void dequeue() {
		if(front==-1 && rear ==-1) {
			System.out.println("Queue is empty");
			//return null;
		}
		else if(front == rear) {
			int value=queue[front];
			front=-1;
			rear=-1;
			System.out.println("Dequeued Value "+value);
		}
		else {
			int value =queue[front];
			front=(front+1)%size;
			System.out.println("Dequeued Value "+value);
		}
		
	}
	
	
	public void display() {
		if(front ==-1 && rear ==-1) {
			System.out.println("queue is empty");
		}
		else if (rear < front){
			for(int i=front;i<size;i++) {
				System.out.println(queue[i]);
			}
			for(int i=0;i<=rear;i++) {
				System.out.println(queue[i]);
			}
			
		}
		else {
			for(int i=front;i<=rear;i++) {
				System.out.println(queue[i]);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue(23);
		queue.enqueue(20);
		queue.enqueue(12);
		queue.enqueue(10);
		queue.enqueue(8);
		queue.display();
		
		queue.dequeue();
		
		queue.enqueue(8);
		queue.display();
	}
	

}
