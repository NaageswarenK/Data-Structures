package algorithm;


class Node{
	private int data;
	private Node next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}

public class OpenHashing {
	
	private int size;
	private Node[] hashtable;
	
	public OpenHashing(int size) {
		this.size=size;
		hashtable = new Node[size];
	}
	
	public void insert(int key) {
		int index=key%size;
		
		Node node = new Node();
		node.setData(key);
		
		if(hashtable[index]==null) {
			hashtable[index]=node;
		}
		else {
			node.setNext(hashtable[index]);
			hashtable[index]=node;
		}
	}
	
	public void delete(int key) {
		int index=key%size;
		
		if(hashtable[index].getData()==key) {
			hashtable[index]=hashtable[index].getNext();
		}
		else {
			Node temp=hashtable[index];
			while(temp.getNext()!=null && temp.getNext().getData()!=key) {
				temp=temp.getNext();
			}
			if(temp.getNext()!=null) {
				temp.setNext(temp.getNext().getNext());
			}
		}
	}
	
	public Boolean search(int key) {
		int index=key%size;
		
		if(hashtable[index].getData()==key) {
			return true;
		}
		else {
			Node temp=hashtable[index];
			while(temp.getNext()!=null && temp.getNext().getData()!=key) {
				temp=temp.getNext();
			}
			if(temp.getNext()!=null) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.printf("Chain[%d] ->",i);
			Node temp=hashtable[i];
			while(temp!=null) {
				System.out.printf("%d ->",temp.getData());
				temp=temp.getNext();
			}
			System.out.printf("null\n");
		}
	}
	
	public static void main(String[] args) {
		OpenHashing hash=new OpenHashing(5);
		hash.insert(35);
		hash.insert(25);
		hash.insert(12);
		hash.insert(89);
		System.out.println(hash.search(10));
		hash.delete(35);
		hash.print();
	}

}
