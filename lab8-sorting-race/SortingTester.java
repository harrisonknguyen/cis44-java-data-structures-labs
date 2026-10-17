import java.util.Arrays;
import java.util.Random;

public class SortingTester {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            System.out.println("\nAverage Case: ");
            runAndTimeAllSorts(generateRandomArray(n));

            System.out.println("\nBest Case: ");
            runAndTimeAllSorts(generateSortedArray(n));

            System.out.println("\nWorst Case: ");
            runAndTimeAllSorts(generateReverseSortedArray(n));
        }
    }

    public static void runAndTimeAllSorts(int[] arr) {
        // Copy array into each sorting method
        int[] selectionArray = arr.clone();
        int[] insertionArray = arr.clone();
        int[] mergeArray = arr.clone();

        // Selection Sort execution time
        long startTime = System.nanoTime();
        SortingAlgorithms.selectionSort(selectionArray);
        long endTime = System.nanoTime();
        System.out.println("Selection Sort: " +
                (endTime - startTime) / 1000000.0 + " ms");

        // Insertion Sort execution time
        startTime = System.nanoTime();
        SortingAlgorithms.insertionSort(insertionArray);
        endTime = System.nanoTime();
        System.out.println("Insertion Sort: " +
                (endTime - startTime) / 1000000.0 + " ms");

        // Merge Sort execution time
        startTime = System.nanoTime();
        SortingAlgorithms.mergeSort(mergeArray);
        endTime = System.nanoTime();
        System.out.println("Merge Sort: " +
                (endTime - startTime) / 1000000.0 + " ms");
    }

    public static int[] generateRandomArray(int size) {

        // Use random to fill an array with random int
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {

        // Create an array that increments by 1
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {

        // Create an array that decreases by 1
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}

