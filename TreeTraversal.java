import java.util.*;
 
public class TreeTraversal {
 
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

        static void printType(ORDER order) {
		switch (order) {
		case PREORDER:
			System.out.print("PREORDER TRAVERSAL\t");
			break;
		case INORDER:
			System.out.print("IN-ORDER TRAVERSAL\t");
			break;
		case POSTORDER:
			System.out.print("POST-ORDER TRAVERSAL\t");
			break;
		case LEVEL:
			System.out.print("LEVEL TRAVERSAL\t\t");
			break;
		}
	}		
			
        
 
	static enum ORDER {
		PREORDER, INORDER, POSTORDER, LEVEL
	}
 
	static void traverse(Node<?> node, ORDER order) {


		if (node == null) {
			return;
		}
		switch (order) {
		case PREORDER:
			node.visit();
			traverse(node.left, order);
			traverse(node.right, order);
			break;
		case INORDER:
			traverse(node.left, order);
			node.visit();
			traverse(node.right, order);
			break;
		case POSTORDER:
			traverse(node.left, order);
			traverse(node.right, order);
			node.visit();
			break;
		case LEVEL:
			Queue<Node<?>> queue = new LinkedList<>();
			queue.add(node);
			while(!queue.isEmpty()){
				Node<?> next = queue.remove();
				next.visit();
				if(next.left!=null)
					queue.add(next.left);
				if(next.right!=null)
					queue.add(next.right);
			}
		}
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
 
		one.left   = two;
		one.right  = three;
		two.left   = four;
		two.right  = five;
		three.left = six;
		four.left  = seven;
		six.left   = eight;
		six.right  = nine;
 
		printType(ORDER.PREORDER);
		traverse(one, ORDER.PREORDER);
		System.out.println(); 

		printType(ORDER.INORDER);
		traverse(one, ORDER.INORDER);
		System.out.println();

		printType(ORDER.POSTORDER);
		traverse(one, ORDER.POSTORDER);
		System.out.println();

		printType(ORDER.LEVEL);
		traverse(one, ORDER.LEVEL);
		System.out.println();
 
	}
}