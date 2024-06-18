import java.util.Arrays;

public class NextPermutation {
    // This method modifies the input array to its next permutation in lexicographic
    // order
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        // Step 1: Find the first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no such element is found, the array is sorted in descending order
        if (index == -1) {
            reverse(nums, 0, n - 1); // Reverse the entire array to get the smallest permutation
            return;
        }

        // Step 3: Find the element just larger than nums[index] from the end
        for (int j = n - 1; j > index; j--) {
            if (nums[j] > nums[index]) {
                swap(nums, index, j); // Swap them
                break;
            }
        }

        // Step 4: Reverse the elements after index to get the next smallest
        // lexicographic permutation
        reverse(nums, index + 1, n - 1);
    }

    // Helper method to swap two elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a portion of an array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end); // Swap elements at start and end
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        NextPermutation np = new NextPermutation();
        // Test case 1
        int[] nums = { 1, 2, 3 };
        System.out.println("Original array: " + Arrays.toString(nums));
        np.nextPermutation(nums);
        System.out.println("Next permutation: " + Arrays.toString(nums));

        // Test case 2
        int[] nums2 = { 3, 2, 1 };
        System.out.println("Original array: " + Arrays.toString(nums2));
        np.nextPermutation(nums2);
        System.out.println("Next permutation: " + Arrays.toString(nums2));

        // Test case 3
        int[] nums3 = { 1, 1, 5 };
        System.out.println("Original array: " + Arrays.toString(nums3));
        np.nextPermutation(nums3);
        System.out.println("Next permutation: " + Arrays.toString(nums3));
    }
}


// Example (2, 1, 5, 4, 3, 0, 0)
// Initial Array
// The initial array is: {2, 1, 5, 4, 3, 0, 0}

// Step 1: Find the first decreasing element from the end
// Start from the second-last element (index 5):

// Compare nums[5] = 0 with nums[6] = 0.
// Since 0 is not less than 0, move to the previous element.
// Move to index 4:

// Compare nums[4] = 3 with nums[5] = 0.
// Since 3 is not less than 0, move to the previous element.
// Move to index 3:

// Compare nums[3] = 4 with nums[4] = 3.
// Since 4 is not less than 3, move to the previous element.
// Move to index 2:

// Compare nums[2] = 5 with nums[3] = 4.
// Since 5 is not less than 4, move to the previous element.
// Move to index 1:

// Compare nums[1] = 1 with nums[2] = 5.
// Since 1 is less than 5, we identify the first decreasing element. Here, index = 1.
// Step 2: Find the element just larger than nums[index] to swap with
// Start from the last element (index 6):

// Compare nums[6] = 0 with nums[1] = 1.
// Since 0 is not greater than 1, move to the previous element.
// Move to index 5:

// Compare nums[5] = 0 with nums[1] = 1.
// Since 0 is not greater than 1, move to the previous element.
// Move to index 4:

// Compare nums[4] = 3 with nums[1] = 1.
// Since 3 is greater than 1, we find the element to swap. Swap nums[1] and nums[4].
// Step 3: Perform the swap
// After swapping, the array becomes: {2, 3, 5, 4, 1, 0, 0}
// Step 4: Reverse the sub-array after the swapped element
// Identify the sub-array to reverse:

// The sub-array starts from index + 1 which is 2 and goes to the end.
// Sub-array is {5, 4, 1, 0, 0}.
// Reverse the sub-array:

// Swap 5 with 0, making the array: {2, 3, 0, 4, 1, 0, 5}.
// Swap 4 with 0, making the array: {2, 3, 0, 0, 1, 4, 5}.
// The array is now fully reversed in this part.
// Final Array
// The next permutation of the array {2, 1, 5, 4, 3, 0, 0} is {2, 3, 0, 0, 1, 4, 5}.