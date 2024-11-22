import java.util.HashMap;

public class fibnoai {

    // Time Complexity : o(2^n);
    // Space Complexity : o(n)
    public static int fib(int n) {

        // Base Case
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // Optimize it by memoization
    private static HashMap<Integer, Integer> map = new HashMap<>();

    // Time Complexity: 𝑂(𝑛)
    // Space Complexity: 𝑂(𝑛)
    public static int fibmemo(int n) {
        // Check Base Case
        if (n <= 1) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans = fibmemo(n - 1) + fibmemo(n - 2);
        map.put(n, ans);

        return ans;
    }

    // Solved by Tabulation
    // Time Complexity: 𝑂(𝑛)
    // Space Complexity: 𝑂(𝑛)
    public static int fibbytabulation(int n) {
        // Base Case
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Space optimization code
    // Time Complexity: 𝑂(𝑛)
    // Space Complexity: 𝑂(1)
    
    public static int fibspaceoptimization(int n) {

        int prev1 = 1, prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int temp = prev1 + prev2;
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {

        System.out.println(fibmemo(10));
        System.out.println(fibbytabulation(10));
        System.out.println(fibspaceoptimization(10));

    }
}