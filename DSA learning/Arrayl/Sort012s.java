public class Sort012s {
    // Method to sort an array of 0s, 1s, and 2s in-place
    public void sortColors(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Initialize three pointers: low, mid, and high
        // low points to the start of the array where 0s should go
        // mid scans the array from left to right
        // high points to the end of the array where 2s should go
        int low = 0, mid = 0, high = n - 1;

        // Loop until mid crosses or meets high
        while (mid <= high) {
            // If the element at mid is 0, swap it with the element at low
            // Increment both low and mid pointers
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            // If the element at mid is 1, simply move to the next element (increment mid)
            else if (nums[mid] == 1) {
                mid++;
            }
            // If the element at mid is 2, swap it with the element at high
            // Decrement high pointer
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Helper method to swap two elements in an array
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main method as the entry point of the program
    public static void main(String args[]) {
        Sort012s sorter = new Sort012s();

        // Example usage: sorting an array containing 0s, 1s, and 2s
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sorter.sortColors(nums);

        // Output the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}


//example explaination in DSA notes Refer
