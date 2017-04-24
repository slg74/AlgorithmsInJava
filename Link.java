public class Link {
	public String bookName;
	public int millionsSold;

	public Link next;

	public Link(String bookName, int millionsSold) {
		this.bookName = bookName;
		this.millionsSold = millionsSold;
	}

	public void display() {
		System.out.println(bookName + ": " + millionsSold + ",000,000");
	}

	public String toString() {
		return bookName;
	}

	public static void main(String[] args) { LinkList ls = new LinkList();
		ls.insertFirstLink("Don Quixote", 500); 
		ls.insertFirstLink("A Tale of Two Cities", 200); 
		ls.insertFirstLink("The Lord of the Rings", 150);
		ls.insertFirstLink("Harry Potter and the Sorcerer's Stone", 750);
		ls.display();

		System.out.println(ls.find("The Lord of the Rings") + " was found"); 

		String bk = "Ready Player One";
		if (ls.find(bk) != null) {
			System.out.println("Found book: " + bk);
		} else {
			System.out.println("Did not find book: " + bk);
		}
	}
}
