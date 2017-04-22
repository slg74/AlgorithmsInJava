public class LeftRotate {

	public static void leftRotate(int[] arr, int d, int n) {
		for (int i=0; i<d; i++) {
			leftRotateByOne(arr, n); 
		}
	}

	public static void leftRotateByOne(int[] arr, int n) {
		int i;
		int temp;
		temp = arr[0];
		for (i=0; i<n-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[i] = temp;
	}

	public static void printArray(int[] arr, int size) {
		int i;
		for (i=0; i<size; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}


	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		leftRotate(arr, 4, 5);
		printArray(arr, 5); 
		System.out.println(); 
	}

}