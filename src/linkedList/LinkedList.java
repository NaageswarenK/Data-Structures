package linkedList;

public class LinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	
	public boolean insertFirst(Node node) {
		
			node.setNext(head);
			head=node;
			return true;
		
	}
	
	public boolean insertLast(Node node) {
		if(head==null) {
			head=node;
			return true;
		}
		else {
			System.out.print("executed");
			Node temp=head;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			temp.setNext(node);
			return true;
		}
	}
	
	public boolean insertMiddle(Integer beforeData,Node node) {
		if(head==null) {
			return false;
		}
		else {
			Node temp=head;
			while(temp.getData()!=beforeData && temp.getNext()!=null) {
				temp=temp.getNext();
			}
			if(temp.getNext()!=null) {
				node.setNext(temp.getNext());
				temp.setNext(node);
				return true;
				
			}
			return false;
		}
	}
	
	public boolean deleteNode(Integer data) {
		if(head.getData()==data) {
			Node temp=head;
			head=head.getNext();
			temp=null;
			return true;
		}
		else {
		Node prev=head;
		Node temp=head;
		while(temp.getData()!=data && temp.getNext()!=null) {
			prev=temp;
			temp=temp.getNext();
		}
		if(temp.getData()==data) {
			prev.setNext(temp.getNext());
			temp=null;
			return true;
		}
		return false;
		}
	}
	
	public boolean searchNode(Integer data) {
		Node temp=head;
		while(temp.getData()!=data && temp.getNext()!=null) {
			temp=temp.getNext();
		}
		if(temp.getData()==data)
			return true;
		return false;
	}
	
	public void print() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
		System.out.print("null");
	}
	
	public void reverse() {
		if(head==null) {
			return;
		}
		System.out.println();
		Node current =head;
		Node next=head;
		Node prev=null;
		while(current!=null) {
		next=current.getNext();
		current.setNext(prev);
		prev=current;
		current=next;
		//current.setNext(next);
		}
		this.head=prev;
	}
	
	public void reverseSublist(int start,int end) {
		Node startNode=head;
		Node endNode =head;
		Node temp=null;
		int i=0;
		while(i!=start-1) {
			temp=startNode;
			startNode=startNode.getNext();
			endNode=endNode.getNext();
			i++;
		}
		while(i!=end) {
			endNode=endNode.getNext();
			i++;
		}
		Node prev=temp;
		Node current=startNode;
		Node next=startNode;
		while(current!=endNode) {
			next=current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
		}
		temp.getNext().setNext(current);
		temp.setNext(prev);
		
		
	}
	
	public void reverseK(int k) {
		Node temp=null;
		Node next=head;
		Node current=head;
		Node prev=temp;
		int i=0;
		while(true) {
			if(i!=k) {
				next=current.getNext();
				current.setNext(prev);
				prev=current;
				current=next;
				i++;
			}else {
				if(temp==null) {
					head.setNext(current);
					temp=head;
					head=prev;
					//temp=prev;
					prev=temp;
							//if(current!=null)
					i=0;
					if(current==null)
						break;
					
					//print();
				}
				
				else {
					Node end = prev;
					temp.getNext().setNext(current);
					prev = temp.getNext();
					temp.setNext(end);
					temp = prev;
					//if(current!=null)
					
						i=0;
						if(current==null)
							break;
				}
				 
			}
			
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node head=new Node();
		head.setData(3);
		list.setHead(head);
		
		Node newNode=new Node();
		newNode.setData(5);
		list.insertFirst(newNode);
		
		System.out.println(list.getHead());
		newNode=new Node();
		newNode.setData(8);
		list.insertLast(newNode);
		
		newNode = new Node();
		newNode.setData(11);
		list.insertMiddle(3, newNode);
		
		list.print();
		list.reverseK(2);
		list.print();
		
		
	}
}
