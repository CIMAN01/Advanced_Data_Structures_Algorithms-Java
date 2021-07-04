
// Java program for implementation of Heap Sort
public class HeapSort {

	public void sort(int arr[]) // Build max heap
	{
		int n = arr.length;
		int startIndex = (n - 1) / 2;

		for (int i = startIndex; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// One by one extract an element from heap and place in the end
		for (int i = n - 1; i > 0; i--) {

			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Call heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	void heapify(int arr[], int n, int i)// heapify procedure for creating max heap
	{
		int largest = i; // make root as largest
		int l = 2 * i + 1; // left child
		int r = 2 * i + 2; // right child

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively call heapify to convert into max heap
			heapify(arr, n, largest);
		}
	}

	/* A function to print sorted array */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 11, 45, 99, 7, 68, 123 };

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);
	}

}
