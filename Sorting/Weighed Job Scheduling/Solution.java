import java.util.Arrays;

class Solution {

    // Utility function to find the next non-overlapping job
    static int findNextJob(int i, int[][] jobs) {
        int low = i + 1, high = jobs.length - 1, ans = jobs.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][0] >= jobs[i][1]) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    // Recursive utility function to find maximum profit
    static int maxProfitRec(int i, int[][] jobs) {
        if (i >= jobs.length) return 0;

        int skip = maxProfitRec(i + 1, jobs);
        int next = findNextJob(i, jobs);
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
