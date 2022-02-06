package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;



public class BinarySearchTree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(Node root, Integer data) {

		if (root == null) {
			Node node = new Node();
			node.setData(data);
			root = node;
		} else if (root.getData() < data) {
			if (root.getRight() == null) {
				Node node = new Node();
				node.setData(data);
				root.setRight(node);
			} else {
				insert(root.getRight(), data);
			}
		} else if (root.getData() > data) {
			if (root.getLeft() == null) {
				Node node = new Node();
				node.setData(data);
				root.setLeft(node);
			} else {
				insert(root.getLeft(), data);
			}
		}
	}

	public void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.getLeft());
		System.out.println(root.getData());
		inorder(root.getRight());
	}

	public boolean search(Node root, Integer data) {
		if (root == null) {
			return false;
		}
		if (root.getData() == data) {
			return true;
		}
		if (root.getData() > data) {
			return search(root.getLeft(), data);
		} else {
			return search(root.getRight(), data);
		}

	}

	public Node delete(Node root, Integer data) {
		if (root == null) {
			return null;
		}
		if (root.getData() > data) {
			root.setLeft(delete(root.getLeft(), data));
		} else if (root.getData() < data) {
			root.setRight(delete(root.getRight(), data));
		} else {
			if (root.getLeft() == null && root.getRight() == null) {
				return null;
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else if (root.getLeft() == null) {
				return root.getRight();
			} else {
				root.setData(findMin(root.getRight()));
				root.setRight(delete(root.getRight(), root.getData()));
			}
		}
		return root;

	}

	public void bfs(Node root) {
		Queue<Node> queue = new LinkedList<>();
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.getData());
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}

	public int levelOrderSucessor(Node root, int data) {
		Queue<Node> queue = new LinkedList<>();
		if (root == null) {
			return -1;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			// System.out.println(node.getData());
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
			if (node.getData() == data) {
				return queue.peek().getData();
			}
		}
		return -1;
	}

	public int findMin(Node root) {
		Node temp = root;
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp.getData();
	}

	public int minDepth(Node root) {
		Queue<Node> queue = new LinkedList<>();
		Queue<Integer> height = new LinkedList<Integer>();

		if (root == null) {
			return -1;
		}

		queue.add(root);
		height.add(1);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int nodeHeight = height.poll();
			if (node != null) {
			
				if (node.getLeft() == null && node.getRight() == null && queue.isEmpty()) {
					return nodeHeight;
				}
				queue.add(node.getLeft());
				queue.add(node.getRight());
				height.add(nodeHeight+1);
				height.add(nodeHeight+1);
			}
		}
		return 0;
	}
	
	public Boolean bstPathSum(Node root,int sum) {
		if(root == null) {
			return false;
		}
		sum=sum-root.getData();
		if(sum==0 && root.getLeft() == null && root.getRight()==null ) {
			return true;
		}else {
			return bstPathSum(root.getLeft(),sum) || bstPathSum(root.getRight(), sum);
		}
		
	}
	
	public void printAllPath(Node root,int[] arr,int k) {
		
		if(root==null) {
			return;
		}
		arr[k++]=root.getData();
		if(root.getLeft() == null && root.getRight() == null) {
			for(int i=0;i<k;i++) {
				System.out.print(arr[i] +"->");
			}
			System.out.print("null\n");
		}
		else {
			
			printAllPath(root.getLeft(), arr, k);
			printAllPath(root.getRight(), arr, k);
		}
		
	}
	
	public void mirrorTree(Node root) {
		Queue<Node> queue = new LinkedList<>();
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			// System.out.println(node.getData());
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
			Node left=node.getLeft();
			node.setLeft(node.getRight());
			node.setRight(left);
		}

		
	}
	public static void main(String[] args) {
		Node root = new Node();
		root.setData(100);
		BinarySearchTree bst = new BinarySearchTree();
		bst.setRoot(root);

		bst.insert(root, 50);
		bst.insert(root, 60);
		bst.insert(root, 200);
		bst.insert(root, 150);
		bst.insert(root, 170);
		bst.insert(root, 10);
		// bst.inorder(root);
		// System.out.println(bst.search(root, 210));
		// bst.delete(root, 50);
		// bst.inorder(root);
		
		bst.mirrorTree(root);
		bst.inorder(root);
	}

}
