import java.util.Arrays;

class Solution {
    static int maxSumIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int ans = 0;
        for( int i = 0; i < n ; i++ ) {
            // maximum sum of increasing 
            // subsequence ending at a value < a[i]
            int maxSum = 0;
            for( int j = 0; j < i; j++ ) {
                
                // taking max among all smaller indices
                if( arr[j] < arr[i] ) maxSum = Math.max(maxSum, dp[j]);
            }
            
            // adding current element to 
            // the subsequence with max sum
            dp[i] = maxSum+arr[i];
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(arr));
    }
}
