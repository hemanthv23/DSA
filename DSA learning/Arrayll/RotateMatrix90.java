import java.util.Scanner; // Import the Scanner class for taking user input

public class RotateMatrix90 {

    // Method to rotate the matrix 90 degrees clockwise
    public void rotate(int[][] matrix) {
        // Transpose the matrix: convert rows to columns
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j]; // Temporary variable to hold the value
                matrix[i][j] = matrix[j][i]; // Swap elements
                matrix[j][i] = temp; // Complete the swap
            }
        }
        
        // Reverse each row: flip elements horizontally
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length / 2; j++){
                int temp = matrix[i][j]; // Temporary variable to hold the value
                matrix[i][j] = matrix[i][matrix.length - 1 - j]; // Swap elements
                matrix[i][matrix.length - 1 - j] = temp; // Complete the swap
            }
        }
    }

    // Main method to execute the program
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in); // Create Scanner object for user input
        
        // Prompt user for the size of the matrix
        System.out.println("Enter the size of the matrix (n for an nxn matrix):");
        int n = scanner.nextInt(); // Read the size of the matrix
        
        int[][] matrix = new int[n][n]; // Initialize an nxn matrix
        
        // Prompt user to enter the elements of the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) { // Loop through rows
            for (int j = 0; j < n; j++) { // Loop through columns
                matrix[i][j] = scanner.nextInt(); // Read each element
            }
        }
        
        // Create an instance of RotateMatrix90 and rotate the matrix
        RotateMatrix90 rm = new RotateMatrix90();
        rm.rotate(matrix);
        
        // Print the rotated matrix
        System.out.println("Rotated Matrix by 90 degrees clockwise:");
        printMatrix(matrix);
        
        // Close the scanner
        scanner.close();
    }
    
    // Method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // Loop through rows
            for (int j = 0; j < matrix[i].length; j++) { // Loop through columns
                System.out.print(matrix[i][j] + " "); // Print each element followed by a space
            }
            System.out.println(); // New line after each row
        }
    }
}
