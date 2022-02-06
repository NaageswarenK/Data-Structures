package CircularLL;

public class LinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public boolean insertFirst(Node node) {

		if (head == null) {
			node.setNext(node);
			head = node;
			return true;
		} else {
			Node temp = head;
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setNext(head);
			head = node;
			return true;
		}
	}

	public boolean insertLast(Node node) {
		if (head == null) {
			node.setNext(node);
			head = node;
			return true;
		} else {
			System.out.print("executed");
			Node temp = head;
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setNext(head);
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
				temp.setNext(node);
				return true;

			}
			return false;
		}
	}

	public boolean deleteNode(Integer data) {
		if (head.getData() == data) {
			Node temp = head;
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}

			temp.setNext(head.getNext());
			head = head.getNext();
			return true;
		} else {
			Node prev = head;
			Node temp = head;
			while (temp.getData() != data && temp.getNext() != head) {
				prev = temp;
				temp = temp.getNext();
			}
			if (temp.getData() == data) {
				prev.setNext(temp.getNext());
				temp = null;
				return true;
			}
			return false;
		}
	}

	public boolean searchNode(Integer data) {
		Node temp = head;
		while (temp.getData() != data && temp.getNext() != head) {
			temp = temp.getNext();
		}
		if (temp.getData() == data)
			return true;
		return false;
	}

	public void print() {
		Node temp = head;
		while (temp.getNext() != head) {
			System.out.print(temp.getData() + "->");
			temp = temp.getNext();
		}
		System.out.print(temp.getData() + "->");
		// System.out.print("null");
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node head = new Node();
		head.setNext(head);
		head.setData(3);
		list.setHead(head);

		Node newNode = new Node();
		newNode.setData(5);
		list.insertFirst(newNode);

		// System.out.println(list.getHead());
		newNode = new Node();
		newNode.setData(8);
		list.insertLast(newNode);

		newNode = new Node();
		newNode.setData(11);
		list.insertMiddle(3, newNode);
		//list.print();

		list.deleteNode(3);
		list.print();
		System.out.println(list.searchNode(8));
	

	}
}
