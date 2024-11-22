import java.util.HashMap;

public class climbstairs {

    // Time Complexity : o(2^n);
    // Space Complexity : o(n);
    public static int climbStairs(int n) {
        // Base Case
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // Time Complexity : o(n);
    // Space Complexity : o(n);
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static int climbStairsmemoization(int n) {
        // Base Case
        if (n <= 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans = climbStairs(n - 1) + climbStairs(n - 2);

        map.put(n, ans);

        return ans;
    }

    // Best Tabulation Approch
    // Time Complexity : o(n);
    // Space Complexity : o(n);

    public static int climbStairstabulation(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Most Optimized Approch
    // Time Complexity : o(n);
    // Space Complexity : o(1);
    public static int climbStairsoptimized(int n) {
        // Base Case
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }

    public static void main(String[] args) {

    }
}
