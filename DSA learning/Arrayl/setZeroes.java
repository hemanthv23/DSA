 class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length; // number of rows
        int m = matrix[0].length; // number of columns in row [0]

        boolean[] row = new boolean[n]; // array to track rows that should be zeroed
        boolean[] cols = new boolean[m]; // array to track columns that should be zeroed

        // First pass: identify all rows and columns that should be zeroed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) { // if an element is zero
                    row[i] = true; // mark the row
                    cols[j] = true; // mark the column
                }
            }
        }

        // Second pass: set elements to zero based on marked rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || cols[j]) { // if the row or column is marked
                    matrix[i][j] = 0; // set the element to zero
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }; // initialize the matrix
        Solution solution = new Solution(); // create an instance of the Solution class
        solution.setZeroes(matrix); // call the setZeroes method to modify the matrix 

        // Printing the modified matrix
        for (int i = 0; i < matrix.length; i++) { // iterate through rows
            for (int j = 0; j < matrix[0].length; j++) { // iterate through columns
                System.out.print(matrix[i][j] + " "); // print each element
            }
            System.out.println(); // move to the next line after each row
        }
    }
}
