public class RepeatMissingNum {

    // Method to find the missing and repeated values in the grid
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length; // Size of the grid (n x n)
        long s = 0, sqrsum = 0, N = n * n; // Variables to store sum, sum of squares, and total number of elements
        long sn = (N * (N + 1)) / 2; // Expected sum of first N natural numbers
        long s2n = (N * (N + 1) * (2 * N + 1)) / 6; // Expected sum of squares of first N natural numbers

        // Loop to calculate the actual sum and sum of squares of elements in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s += grid[i][j]; // Add each element to the sum
                sqrsum += (long) grid[i][j] * grid[i][j]; // Add the square of each element to the sum of squares
            }
        }

        // Calculate the difference between actual sum and expected sum
        long val1 = s - sn; // This is (repeated number - missing number)

        // Calculate the difference between actual sum of squares and expected sum of
        // squares
        long val2 = sqrsum - s2n; // This is (repeated number^2 - missing number^2)

        // Calculate (repeated number + missing number)
        val2 = val2 / val1; // This simplifies to (repeated number + missing number)

        // Calculate the repeated number
        long x = (val1 + val2) / 2;

        // Calculate the missing number
        long y = val2 - x;

        // Return the missing number and repeated number as an array
        return new int[] { (int) y, (int) x };
    }

    // Main method to test the functionality
    public static void main(String args[]) {
        RepeatMissingNum sol = new RepeatMissingNum(); // Create an instance of RepeatMissingNum
        int[][] grid = { { 1, 3 }, { 2, 2 } }; // Define the input grid
        int[] result = sol.findMissingAndRepeatedValues(grid); // Call the method to find missing and repeated values
        System.out.println("Repeated: " + result[1] + ", Missing: " + result[0]); // Print the results
    }
}

/*
 * 1D
 * 
 * 
 * public class RepeatMissingNum {
 * 
 * // Method to find the missing and repeated values in the array
 * public int[] findMissingAndRepeatedValues(int[] grid) {
 * int n = grid.length;
 * long s = 0, sqrsum = 0, N = n;
 * long sn = (N * (N + 1)) / 2; // Expected sum of first N natural numbers
 * long s2n = (N * (N + 1) * (2 * N + 1)) / 6; // Expected sum of squares of
 * first N natural numbers
 * 
 * // Loop to calculate the actual sum and sum of squares of elements in the
 * array
 * for (int i = 0; i < n; i++) {
 * s += grid[i]; // Add each element to the sum
 * sqrsum += (long) grid[i] * grid[i]; // Add the square of each element to the
 * sum of squares
 * }
 * 
 * // Calculate the difference between actual sum and expected sum
 * long val1 = s - sn; // This is (repeated number - missing number)
 * 
 * // Calculate the difference between actual sum of squares and expected sum of
 * squares
 * long val2 = sqrsum - s2n; // This is (repeated number^2 - missing number^2)
 * 
 * // Calculate (repeated number + missing number)
 * val2 = val2 / val1; // This simplifies to (repeated number + missing number)
 * 
 * // Calculate the repeated number
 * long x = (val1 + val2) / 2;
 * 
 * // Calculate the missing number
 * long y = val2 - x;
 * 
 * // Return the missing number and repeated number as an array
 * return new int[] {(int) y, (int) x};
 * }
 * 
 * // Main method to test the functionality
 * public static void main(String args[]) {
 * RepeatMissingNum sol = new RepeatMissingNum(); // Create an instance of
 * RepeatMissingNum
 * int[] grid = {1, 3, 2, 2}; // Define the input array
 * int[] result = sol.findMissingAndRepeatedValues(grid); // Call the method to
 * find missing and repeated values
 * System.out.println("Repeated: " + result[1] + ", Missing: " + result[0]); //
 * Print the results
 * }
 * }
 * 
 */
