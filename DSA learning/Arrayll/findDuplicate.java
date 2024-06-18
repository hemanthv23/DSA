import java.util.Arrays;

public class findDuplicate {
    public static int findDuplicatee(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Traverse the sorted array to find the duplicate element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
  
        // If no duplicate is found (which should not be the case given the problem statement)
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate element: " + findDuplicatee(nums));
    }
}
