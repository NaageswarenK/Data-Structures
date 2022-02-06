package algorithm;

import java.util.Arrays;

public class ClosedHashing {

	private int[] hashtable;
	private int size;

	public ClosedHashing(int size) {
		this.size = size;
		hashtable = new int[size];
		Arrays.fill(hashtable, -1);
	}

	public void insert(int key) {

		int index = key % size;
		int temp = index;

		while (hashtable[temp] != -1) {
			
			temp = (temp + 1) % size;
			if (temp == index) {
				System.out.println("Hashtable is full");
				return;
			}
		}
		hashtable[temp] = key;

	}

	public void delete(int key) {
		int index = key % size;
		int temp = index;
		while (hashtable[temp] != key) {
			
			temp = (temp + 1) % size;
			if (temp == index) {
				System.out.println("Key Not found");
				return;
			}
		}
		hashtable[temp] = -1;
	}

	public boolean search(int key) {
		int index = key % size;
		int temp = index;
		while (hashtable[temp] != key) {
			
			temp = (temp + 1) % size;
			if (temp == index) {
				// System.out.println("Hashtable is full");
				return false;
			}
		}
		return true;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(hashtable[i]);
		}
	}

	public static void main(String[] args) {
		ClosedHashing hash = new ClosedHashing(5);
		hash.insert(16);
		hash.insert(12);

		hash.insert(3);
		hash.insert(6);
		hash.insert(20);
		//hash.insert(71);
		
		hash.delete(80);

		hash.print();
	}

}
