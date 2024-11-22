import java.util.ArrayList;
import java.util.HashMap;

public class maxadjacentelement {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.

        int ans = helper(nums, 0);

        return ans;

    }

    public static int helper(ArrayList<Integer> nums, int index) {
        // Check Base Case
        if (index >= nums.size()) {
            return 0;
        }
        // Include the current Element
        int include = nums.get(index) + helper(nums, index + 2);

        // Exclude the current Elemenet
        int exclude = helper(nums, index + 1);

        int ans = Math.max(include, exclude);

        return ans;
    }

    public static int maximumNonAdjacentSummemoization(ArrayList<Integer> nums) {
        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = helper(nums, 0, map);

        return ans;

    }

    public static int helper(ArrayList<Integer> nums, int index, HashMap<Integer, Integer> map) {
        // Check Base Case
        if (index >= nums.size()) {
            return 0;
        }

        // Check if the index is already present in the Hashmap
        if (map.containsKey(index)) {
            return map.get(index);
        }

        // Include the current Element
        int include = nums.get(index) + helper(nums, index + 2, map);

        // Exclude the current Elemenet
        int exclude = helper(nums, index + 1, map);

        int ans = Math.max(include, exclude);

        // Put the value in the map
        map.put(index, ans);

        return ans;
    }

    public static int maximumNonAdjacentSumtabulation(ArrayList<Integer> nums) {
        // Write your code here.
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        // If there is only one element
        if (nums.size() == 1) {
            return nums.get(0);
        }

        int n = nums.size();

        int[] dp = new int[n];

        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(1), nums.get(0));

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums.get(i) + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];

    }


    public static int maximumNonAdjacentSpaceOptimization(ArrayList<Integer> nums) {
        // Write your code here.
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        // If there is only one element
        if (nums.size() == 1) {
            return nums.get(0);
        }

        int n = nums.size();

        int prev2 = nums.get(0);
        int prev1 = Math.max(nums.get(1), nums.get(0));

        for (int i = 2; i < n; i++) {
            int temp = Math.max(nums.get(i) + prev2, prev1);
            prev2 = prev1;
            prev1 =  temp;
        }

        return prev1;

    }

    public static void main(String[] args) {

    }
}
