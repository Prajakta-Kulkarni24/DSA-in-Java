import java.util.*;

class Solution {

    // edges[i] = {u, v, w1, w2}
    static int shortestPath(int n, int a, int b, int[][] edges) {

        // Build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w1 = e[2], w2 = e[3];

            adj.get(u).add(new int[]{v, w1, w2});
            adj.get(v).add(new int[]{u, w1, w2});
        }

        int INF = (int)1e9;

        // dist[node][usedCurve]
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        dist[a][0] = 0;
        pq.add(new int[]{0, a, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], node = cur[1], used = cur[2];

            if (d != dist[node][used]) continue;

            for (int[] it : adj.get(node)) {
                int nxt = it[0];
                int w1 = it[1];
                int w2 = it[2];

                // use normal edge
                if (dist[nxt][used] > d + w1) {
                    dist[nxt][used] = d + w1;
                    pq.add(new int[]{dist[nxt][used], nxt, used});
                }

                // use curved edge (only once)
                if (used == 0) {
                    if (dist[nxt][1] > d + w2) {
                        dist[nxt][1] = d + w2;
                        pq.add(new int[]{dist[nxt][1], nxt, 1});
                    }
                }
            }
        }

        int ans = Math.min(dist[b][0], dist[b][1]);
        return ans >= INF ? -1 : ans;
    }
}
