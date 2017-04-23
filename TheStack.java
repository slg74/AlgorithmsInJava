import java.util.Arrays;

public class TheStack {
	private String[] stackArray;
	private int stackSize;    // size of the array 
	private int topOfStack = -1;   

	TheStack(int size) {
		stackSize = size;
		stackArray = new String[size];

		Arrays.fill(stackArray, "-1");
	}

	public void push(String input) {
		if (topOfStack + 1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = input;
		} else {
			System.out.println("Stack is full.");
			displayTheStack();
			System.out.println("PUSH " + input + " was added to the stack.");
		}
	}

	public String pop() {
		if (topOfStack >= 0) {
			displayTheStack();
			System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack.");
			stackArray[topOfStack] = "-1";
			return stackArray[topOfStack--];
		} else {
			displayTheStack(); 
			System.out.println("Stack is empty.");
			return "-1";
		}
	}

	public String peek() {
		if (topOfStack == -1) {
			System.out.println("Stack is empty."); 
			return "-1";
		} else {
			displayTheStack();
			System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack."); 
			return stackArray[topOfStack];
		}
	}

	public void drawBorder() {
		for (int i=0; i<61; i++) {
			System.out.print("-");
		}
		System.out.println(); 
	}

	public void displayTheStack() {

		drawBorder();

		for (int i=0; i<stackSize; i++) {
			System.out.format("| %2s " + " ", i);
		}
		System.out.println("|"); 

		drawBorder(); 

		for (int i=0; i<stackSize; i++) {
			if (stackArray[i].equals("-1")) {
				System.out.print("|     "); 
			} else {
				System.out.print(String.format("| %2s " + " ", stackArray[i]));
			}
		}
		System.out.println("|"); 

		drawBorder(); 
	}

	public void popAll() {
		for (int i=topOfStack; i>0; i--) {
			pop();
		}
	}

	public static void main(String[] args) {
		TheStack s = new TheStack(10);
		s.push("10");
		s.push("19"); 
		s.push("93"); 
		s.push("22"); 
		s.push("13");
		s.push("5");
		s.push("29"); 
		s.push("19"); 
		s.push("78"); 
		s.push("32"); 
		s.push("12"); 
		s.displayTheStack();
		System.out.println("Calling popAll...");
		s.popAll(); 
		s.displayTheStack();
		s.pop(); 
		s.displayTheStack();
		s.peek(); 
	}
}
