class Node {
	Node left, right;
	int data;
	public Node(int data) {	
		this.data = data; 
	}

	public void insert(int value) {
		if (value <= data) {		
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value); 
			}
		}
	}

	public static void main(String[] args) {

		Node a = new Node(5); 
		Node b = new Node(10); 
		Node c = new Node(15); 
		Node d = new Node(8); 

		b.left = a;
		b.right = c;

		printInOrder(b); 

		System.out.println("After inserting 8..."); 
		b.insert(8); 
		printInOrder(b); 

		System.out.println();

		System.out.println("After inserting 22...");
		b.insert(22);
		printInOrder(b); 
	}

	public boolean contains(int value) {
		if (value == data) {
			return true;
		} else if (value < data) {	
			if (left == null) {
				return false;
			} else {
				return left.contains(value); 
			}
		} else {
			if (right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}

	public static void printInOrder(Node n) {
		if (n.left != null) {
			n.left.printInOrder(n.left); 
		}
		System.out.println(n.data);
		if (n.right != null) {
			n.right.printInOrder(n.right); 
		}
	}
}
