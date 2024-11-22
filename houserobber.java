import java.util.HashMap;

// Memoization
// Time Complexity : o(2^n);
// Space Complexity: o(n);
public int rob(int[] nums) {

    HashMap<Integer, Integer> map = new HashMap<>();
    int ans = helper(nums, 0, map);

    return ans;
}

public int helper(int[] nums, int index, HashMap<Integer, Integer> map) {
    // Base Case
    if (index >= nums.length) {
        return 0;
    }

    // if map contains the index
    if (map.containsKey(index)) {
        return map.get(index);
    }

    // Include the Current Index
    int include = nums[index] + helper(nums, index + 2, map);

    int exclude = helper(nums, index + 1, map);

    int ans = Math.max(include, exclude);

    map.put(index, ans);

    return ans;
}

// Tabulaion
// Time Complexity : o(n);
// Space Complexity: o(n);
public static int robtabulatiom(int[] nums) {
    // Base Case
    if (nums.length == 0 || nums == null) {
        return 0;
    }
    if (nums.length == 1) {
        return nums[0];
    }
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }

    return dp[n - 1];
}

// Space Optimization
// Time Complexity : o(n);
// Space Complexity: o(1);
public int robspaceoptimie(int[] nums) {
    // Base Case
    if (nums.length == 0 || nums == null) {
        return 0;
    }
    if (nums.length == 1) {
        return nums[0];
    }
    int n = nums.length;
    int prev2 = nums[0];
    int prev1 = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
        int temp = Math.max(nums[i] + prev2, prev1);
        prev2 = prev1;
        prev1 = temp;
    }

    return prev1;
}

public static void main(String[] args) {

}
