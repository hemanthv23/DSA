import java.util.Scanner;

class BuySell {
    public int maxProfit(int[] prices) {
        // Initialize the minimum price to the first element of the array
        int min = prices[0];
        // Initialize the maximum profit to 0
        int Profit = 0;
        // Get the length of the input array
        int n = prices.length;
        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Calculate the difference between the current price and the minimum price seen
            // so far
            int cost = prices[i] - min;
            // Update the maximum profit seen so far
            Profit = Math.max(Profit, cost);
            // Update the minimum price seen so far
            min = Math.min(min, prices[i]);
        }
        // Return the maximum profit
        return Profit;
    }

    public static void main(String args[]) {

        BuySell solution = new BuySell();

        // Take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of stock prices: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        scanner.close();

        // Calculate and print the maximum profit
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}

// Explanation for the input [7, 1, 5, 3, 6, 4]:

// Initially, the minimum price is 7, and the maximum profit is 0.
// At index 1, the price is 1, so the cost (difference between the price and the
// minimum) is -6. Since -6 is less than 0, the maximum profit remains 0.
// At index 2, the price is 5, so the cost is 5 - 1 = 4. Since 4 is greater than
// 0 (the current maximum profit), the maximum profit is updated to 4.
// At index 3, the price is 3, so the cost is 3 - 1 = 2. Since 2 is less than 4,
// the maximum profit remains 4.
// At index 4, the price is 6, so the cost is 6 - 1 = 5. Since 5 is greater than
// 4, the maximum profit is updated to 5.
// At index 5, the price is 4, so the cost is 4 - 1 = 3. Since 3 is less than 5,
// the maximum profit remains 5.
// The maximum profit is 5, which occurs if you buy at $1 and sell at $6.