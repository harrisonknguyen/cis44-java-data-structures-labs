import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // Generate a random array and time both algorithms.
            int[] arr = generateRandomArrayWithNegatives(n);

            // Brute Force execution time
            long startTime = System.nanoTime();
            int bruteForceSum = MaxSubarraySolver.bruteForceMaxSum(arr);
            long endTime = System.nanoTime();
            System.out.println("Brute Force Sum: " + bruteForceSum);
            System.out.println("Brute Force Time: " +
                    (endTime - startTime) / 1000000.0 + " ms");

            // Kadane's Algorithm execution time
            startTime = System.nanoTime();
            int kadaneSum = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            endTime = System.nanoTime();
            System.out.println("Kadane's Sum: " + kadaneSum);
            System.out.println("Kadane's Time: " +
                    (endTime - startTime) / 1000000.0 + " ms");

            // Check if both algorithms return the same sum
            if (bruteForceSum == kadaneSum) {
                System.out.println("Results match!");
            } else {
                System.out.println("Results do not match!");
            }
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100;
        }

        return arr;
    }
}