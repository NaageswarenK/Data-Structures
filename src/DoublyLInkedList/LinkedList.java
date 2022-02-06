package DoublyLInkedList;

public class LinkedList {

	private Node head, tail;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public boolean insertFirst(Node node) {

		if (head == null && tail == null) {
			head = node;
			tail = node;
			return true;
		} else {
			node.setNext(head);
			head.setPrevious(node);
			head = node;
			return true;
		}
	}

	public boolean insertLast(Node node) {
		if (head == null && tail == null) {
			head = node;
			tail = node;
			return true;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
			return true;
		}
	}

	public boolean insertMiddle(Integer beforeData, Node node) {
		if (head == null) {
			return false;
		} else {
			Node temp = head;
			while (temp.getData() != beforeData && temp.getNext() != null) {
				temp = temp.getNext();
			}
			if (temp.getNext() != null) {
				node.setNext(temp.getNext());
				temp.getNext().setPrevious(node);
				node.setPrevious(temp);
				temp.setNext(node);
				return true;

			}
			return false;
		}
	}

	public boolean deleteNode(Integer data) {
		if (head.getData() == data) {
			Node temp = head;
			head = head.getNext();
			head.setPrevious(null);
			temp = null;
			return true;
		}else if(tail.getData()==data) {
			Node temp=tail;
			tail=tail.getPrevious();
			tail.setNext(null);
			temp=null;
			return true;
			
		}
		else {
			// Node prev=head;
			Node temp = head;
			while (temp.getData() != data && temp.getNext() != null) {
				// prev=temp;
				temp = temp.getNext();
			}
			if (temp.getData() == data) {
				temp.getPrevious().setNext(temp.getNext());
				temp.getNext().setPrevious(temp.getPrevious());
				temp = null;
				return true;
			}
			return false;
		}
	}

	public boolean searchNode(Integer data) {
		Node temp = head;
		while (temp.getData() != data && temp.getNext() != null) {
			temp = temp.getNext();
		}
		if (temp.getData() == data)
			return true;
		return false;
	}

	public void print() {
		Node temp = head;
		Node prev = tail;
		while (temp != null) {
			System.out.print(temp.getData() + "->");
			// prev = temp;
			temp = temp.getNext();
		}
		System.out.println();
		while (prev != null) {
			System.out.print(prev.getData() + "->");
			prev = prev.getPrevious();
		}
		// System.out.print("null");
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node head = new Node();
		head.setData(3);
		list.setHead(head);
		list.setTail(head);

		Node newNode = new Node();
		newNode.setData(5);
		list.insertFirst(newNode);
		// list.print();

		newNode = new Node();
		newNode.setData(8);
		list.insertLast(newNode);
		// list.print();

		newNode = new Node();
		newNode.setData(11);
		list.insertMiddle(3, newNode);
		//list.print();

		list.deleteNode(11);
		list.print();
		System.out.println(list.searchNode(11));
		/*
		 * list.deleteNode(8); System.out.println(list.searchNode(8));
		 */

	}
}
