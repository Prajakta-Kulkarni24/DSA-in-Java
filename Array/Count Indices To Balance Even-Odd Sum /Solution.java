/*
Problem: Count Indices To Balance Even-Odd Sum 
Approach: Using Prefix and Suffix Sum
Time Complexity: O(n)
Space Complexity: O(1) 
*/

class Solution {
    static int cntWays(int[] arr) {
        int n = arr.length;
        int res = 0;
        
        // calculate initial right side sums
        int rightOddSum = 0, rightEvenSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rightEvenSum += arr[i];
            } 
            else {
                rightOddSum += arr[i];
            }
        }
        
        // initialize left side sums
        int leftOddSum = 0, leftEvenSum = 0;
        
        // check for each index
        for (int i = 0; i < n; i++) {
            
            // remove current element from right side
            if (i % 2 == 0) {
                rightEvenSum -= arr[i];
            } 
            else {
                rightOddSum -= arr[i];
            }
            
            // after removing element at index i, indices shift
            // So right side odd becomes even and even becomes odd
            if (leftOddSum + rightEvenSum == 
                        leftEvenSum + rightOddSum) {
                res++;
            }
            
            // add current element to left side
            if (i % 2 == 0) {
                leftEvenSum += arr[i];
            } else {
                leftOddSum += arr[i];
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4};
        System.out.println(cntWays(arr));
    }
}
