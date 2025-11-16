import java.util.Arrays;

class Solution {

    // Recursive utility function to find maximum profit
    static int maxProfitRec(int i, int[][] jobs) {

        // Base case
        if (i >= jobs.length) return 0;

        // Option 1: Skip the current job
        int skip = maxProfitRec(i + 1, jobs);

        // Option 2: Take the current job
        int next = i + 1;
        while (next < jobs.length && jobs[next][0] < jobs[i][1]) next++;
        int take = jobs[i][2] + maxProfitRec(next, jobs);

        return Math.max(take, skip);
    }

    // Function to find maximum profit
    static int maxProfit(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        return maxProfitRec(0, jobs);
    }

    public static void main(String[] args) {
        int[][] jobs = {
            {1, 2, 50},
            {3, 5, 20},
            {6, 19, 100},
            {2, 100, 200}
        };

        System.out.println(maxProfit(jobs));
    }
}
