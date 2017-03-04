import java.util.*;

public class NodeTest {

	static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;

		Node(T value) {
			this.value = value;
		}

		void visit() {
			System.out.print(this.value + " "); 
		}
	}

	static void inOrderTraversal(Node<?> node) {

		if (node == null) {
			return;
		}

		inOrderTraversal(node.left);
		node.visit();
		inOrderTraversal(node.right);
	}

	public static void main(String[] args) {
		Node<Integer> one   = new Node<Integer>(1);
		Node<Integer> two   = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four  = new Node<Integer>(4);
		Node<Integer> five  = new Node<Integer>(5);
		Node<Integer> six   = new Node<Integer>(6);
		Node<Integer> seven = new Node<Integer>(7);
		Node<Integer> eight = new Node<Integer>(8);
		Node<Integer> nine  = new Node<Integer>(9);

		
		one.visit();
		two.visit();
		three.visit();

		System.out.println(); 
		
		one.left   = two;
		one.right  = three;
		two.left   = four;
		two.right  = five;
		three.left = six;
		four.left  = seven;
		six.left   = eight;
		six.right  = nine;
		
		inOrderTraversal(one); 

	}
}
