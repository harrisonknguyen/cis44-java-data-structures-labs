public class SortingAlgorithms {

    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        // Loop array until arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // Search array for value lower than minIndex
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Store arr[i] as a temporary variable, move value of arr[minIndex} to position of arr[i]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        // Starting from second element, loop through and store the current element
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            // Shift bigger elements to the right

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert the current element into it's corrected sorted position
            arr[j + 1] = current;
        }
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        // Divide the array into two and sort each half recursively
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortRecursive(arr, temp, left, mid);
            mergeSortRecursive(arr, temp, mid + 1, right);

            // Merge the two sorted halves into one
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Initialize pointers for temp array and the two halves
        int i = left;
        int j = mid + 1;
        int k = left;

        // Compare and copy the smaller elements from the two halves
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy elements from the left half into the temp array, then the right
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged and sorted sections from the temp array into the original
        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }
}
