import java.util.Scanner; // Import Scanner class to read input

class KadaneS {
    // Function to find the maximum subarray sum
    public int maxSubArray(int[] nums) {
        // Initialize the maximum sum with the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;
        // Get the length of the array
        int n = nums.length;
        // Initialize a variable to store the current sum
        long sum = 0;

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Add the current element to the sum
            sum = sum + nums[i];

            // If the current sum is greater than the maximum sum so far,
            // update the maximum sum
            if (sum > maxSum) {
                // Convert sum back to int before updating maxSum
                maxSum = (int) sum;
            }

            // If the sum becomes negative, reset it to 0
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum sum found
        return maxSum;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt(); // Read the number of elements
        int[] nums = new int[n]; // Create an array to store the elements

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt(); // Read each element and store it in the array
        }

        // Create an instance of KadaneS class
        KadaneS kadaneS = new KadaneS();
        // Call the maxSubArray function and store the result
        int maxSum = kadaneS.maxSubArray(nums);
        // Print the result
        System.out.println("Maximum subarray sum: " + maxSum);

        scanner.close(); // Close the Scanner object to avoid resource leak
    }
}


///example explaination in NOTES - REFERRR(STRIVERS)