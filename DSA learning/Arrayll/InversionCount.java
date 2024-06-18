import java.util.*;

public class InversionCount {

    // Merge function to merge two halves of the array and count inversions
    private static int merge(int[] arr, int low, int mid, int high) {
        // Temporary array to store the merged array
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low; // Starting index of the left half
        int right = mid + 1; // Starting index of the right half

        // cnt variable to count the number of inversions
        int cnt = 0;

        // Merging elements into the temporary array in a sorted manner
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                // If element in the left half is smaller or equal, add it to temp
                temp.add(arr[left]);
                left++;
            } else {
                // If element in the right half is smaller, add it to temp
                temp.add(arr[right]);
                // Count inversions: all remaining elements in the left half are greater
                cnt += (mid - left + 1);
                right++;
            }
        }

        // If there are remaining elements in the left half, add them to temp
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // If there are remaining elements in the right half, add them to temp
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy the sorted elements from temp back to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        // Return the number of inversions counted
        return cnt;
    }

    // MergeSort function to sort the array and count inversions
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0; // Initialize inversion count
        if (low >= high) return cnt; // Base case: if the array has one or no elements
        int mid = (low + high) / 2; // Find the middle index
        cnt += mergeSort(arr, low, mid); // Recursively sort the left half
        cnt += mergeSort(arr, mid + 1, high); // Recursively sort the right half
        cnt += merge(arr, low, mid, high); // Merge the two halves and count inversions
        return cnt; // Return the total number of inversions
    }

    // Function to count the number of inversions in the array
    public static int numberOfInversions(int[] a, int n) {
        return mergeSort(a, 0, n - 1); // Call mergeSort to count inversions
    }

    // Main function to test the inversion count functionality
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1}; // Define the input array
        int n = a.length; // Get the length of the array
        int cnt = numberOfInversions(a, n); // Call numberOfInversions to count inversions
        System.out.println("The number of inversions are: " + cnt); // Print the number of inversions
    }
}


/*  https://takeuforward.org/data-structure/count-inversions-in-an-array/ */