public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = arr[0];

        // Check every possible starting position
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            // Check every possible ending position
            for (int j = i; j < arr.length; j++) {
                currentSum = currentSum + arr[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        // The outer loop runs n times, while inner loop runs n, n-1, n-2 times.
        // It grows proportionally to n^2, so the complexity is O(n^2).
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        // Check each element once, starting from the second element
        for (int i = 1; i < arr.length; i++) {

            // Start a new subarray or continue the current subarray
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
            } else {
                currentSum = currentSum + arr[i];
            }

            // Update the maximum sum found so far
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        // The loop processes each element once, each iteration having the same constant operation
        // Total work grows proportionally to n, so O(n).
        return maxSum;
    }
}