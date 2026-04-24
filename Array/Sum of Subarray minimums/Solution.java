/*
Problem: Sum of Subarray Minimums
Approach: Monotonic Stack (Previous & Next Smaller Elements)
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Stack;

class Solution {

    static int sumSubMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Previous Smaller Element (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && arr[s1.peek()] > arr[i]) {
                s1.pop();
            }
            left[i] = s1.isEmpty() ? (i + 1) : (i - s1.peek());
            s1.push(i);
        }

        // Next Smaller Element (smaller or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                s2.pop();
            }
            right[i] = s2.isEmpty() ? (n - i) : (s2.peek() - i);
            s2.push(i);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i] * left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(sumSubMins(arr));  
    }
}
