import java.util.ArrayList;
import java.util.List;

class Solution {

    public static ArrayList<Integer> constructArr(int[] arr){
        
        // only one pair-sum ⇒ original array has two numbers
        if (arr.length == 1) {
            return new ArrayList<>(List.of(1, arr[0] - 1));
        }

        // compute n from m = n·(n−1)/2  
        // n = (1 + √(1 + 8m)) / 2
        int n = (int) ((1 + Math.sqrt(1 + 8 * arr.length)) / 2);

        int[] res = new int[n];
        
        // res[0] is obtained from the first three relevant sums
        res[0] = (arr[0] + arr[1] - arr[n - 1]) / 2;

        // remaining elements: subtract res[0] from 
        // successive pair sums
        for (int i = 1; i < n; i++) {
            res[i] = arr[i - 1] - res[0];
        }

        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int x : res) ans.add(x);
        return ans;
    }

    public static void main(String[] args) {
    
        int[] arr = {4, 5, 3};
        ArrayList<Integer> res = constructArr(arr);
    
        for (int x : res) System.out.print(x + " ");
    }
}
