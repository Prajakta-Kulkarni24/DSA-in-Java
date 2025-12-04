import java.util.Arrays;

class Solution {
    
    static int totalCost(int mask, int curr, int[][] cost, int[][] dp) {
        
        int n = cost.length;
        
        // Base case: if all cities are visited, return the
        // cost to return to the starting city (0)
        if (mask == (1 << n) - 1) {
            return cost[curr][0];
        }

        // If the value has already been computed, return it
        // from the dp table
        if (dp[curr][mask] != -1) {
            return dp[curr][mask];
        }

        int ans = Integer.MAX_VALUE;

        // Try visiting every city that has not been visited yet
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) { 
              
              // If city i is not visited 
                // Visit city i and update the mask
                ans = Math.min(ans, cost[curr][i]
                                    + totalCost(mask | (1 << i), i, cost, dp));
            }
        }
        
        return dp[curr][mask] = ans;
    }
 
    static int tsp(int[][] cost) {
       
        int n = cost.length;
        
        int[][] dp = new int[n][1 << n];
        
        // Initialize the dpization table with -1
        // (indicating uncomputed states)
        int mask = 1, curr = 0;
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from city 0, with only city 0
        // visited initially (mask = 1)
        return totalCost(mask, curr, cost, dp);  
    }

    public static void main(String[] args) {
        
        int[][] cost = {{0, 10, 15, 20},
                        {10, 0, 35, 25},
                        {15, 35, 0, 30},
                        {20, 25, 30, 0}};
 
        int res = tsp(cost);
        System.out.println(res);
    }
}
