/*
Problem: Police and Thieves
Approach: Using Queue 
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int catchThieves(char[] arr, int k) {
        // Keep track of police and thieve
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thieve = new LinkedList<>();
        int c = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P')
                police.add(i);
            else
                thieve.add(i);
            // process the thieve and police
            while (!police.isEmpty() && !thieve.isEmpty()) {
                if (Math.abs(police.peek() - thieve.peek()) <= k) {
                    c++;
                    police.poll();
                    thieve.poll();
                } else if (police.peek() < thieve.peek())
                    police.poll();
                else
                    thieve.poll();
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int k = 1;
        char[] arr = { 'P', 'T', 'T', 'P', 'T' };
        System.out.println(catchThieves(arr, k));
    }
}
