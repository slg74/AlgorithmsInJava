import java.util.*;

class Link {

	public int key;
	public double data;
	public Link next;

	public Link(int id, double dd) {
		key = id;
		data = dd;
	}

	public void displayLink() {
		System.out.print("{" + key + ", " + data + "} "); 
	}
}
	
class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null); 
	}

	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}

	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.print("List (first->last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(""); 
	}
}

class LinkListApp {
	public static void main(String[] args) {
		LinkList theList = new LinkList();

		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);

		theList.displayList();

		while (!theList.isEmpty()) {
			Link aLink = theList.deleteFirst();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println("");
		}

		theList.displayList();
	}
}

