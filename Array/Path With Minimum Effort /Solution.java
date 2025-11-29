import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    
    // Directions: up, down, left, right
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static int minCostPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int[][] cost = new int[n][m];
        for(int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;

        // {current cost, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                    Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int currCost = top[0], x = top[1], y = top[2];

            // Skip if this is an outdated entry
            if(currCost != cost[x][y]) continue;

            // Destination reached
            if(x == n-1 && y == m-1) return currCost;

            for(int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                
                    // Maximum difference along this path
                    int newCost = Math.max(currCost, 
                                Math.abs(mat[nx][ny] - mat[x][y]));

                    // Update if newCost improves the neighbor
                    if(newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.add(new int[]{newCost, nx, ny});
                    }
                }
            }
        }

        return cost[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] mat = {
            {7,2,6,5},
            {3,1,10,8}
        };
        System.out.println(minCostPath(mat));
    }
}
