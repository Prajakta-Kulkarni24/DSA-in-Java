/*
Problem: Missing and Repeating Number in Array
Approach: Frequency Array
Time Complexity: O(n)
Space Complexity: O(n)
Note: Can be optimized to O(1) space using math or XOR
*/

import java.util.ArrayList;

class Solution {

    static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;

        // frequency array to count occurrences
        int[] freq = new int[n + 1]; 
        int repeating = -1;
        int missing = -1;

        // count frequency of each element
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        // identify missing and repeating numbers
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) missing = i;
            else if (freq[i] == 2) repeating = i;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        ArrayList<Integer> ans = findTwoElement(arr);

        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
