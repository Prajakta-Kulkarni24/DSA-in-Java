// User function Template for Java

class LCIS {

    // Function to find LCIS (Longest Common Increasing Subsequence)
    public int LCIS(int arr1[], int arr2[]) {

        int n = arr1.length;
        int m = arr2.length;

        // dp[j] will store LCIS ending with arr2[j]
        int[] dp = new int[m];

        int result = 0;

        for (int i = 0; i < n; i++) {
            int current = 0;

            for (int j = 0; j < m; j++) {

                if (arr1[i] == arr2[j]) {
                    dp[j] = current + 1;
                }

                if (arr2[j] < arr1[i]) {
                    current = Math.max(current, dp[j]);
                }

                result = Math.max(result, dp[j]);
            }
        }

        return result;
    }
}
