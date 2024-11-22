public class longestcommonsubseuqnce {
    public static int longestCommonSubsequence(String text1, String text2) {

        int row = text1.length();
        int col = text2.length();

        // Create a 2D array to store the lengths of longest common subsequence
        int[][] dp = new int[row + 1][col + 1];

        // Fill the dp array
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest common subsequence is in dp[m][n]
        return dp[row][col];
    }
    public static void main(String[] args) {
        
    }
}
