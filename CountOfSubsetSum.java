import java.util.Arrays;

public class CountOfSubsetSum {
    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;
        int n = arr.length;

        long[][] dp = new long[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // System.out.println(CountOfSubsetSumfunc(arr, n, sum, dp));
        System.out.println(dp[n][sum]);
    }

    public static long CountOfSubsetSumfunc(int[] arr, int n, int sum, long[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (arr[n - 1] <= sum) {
            return dp[n][sum] = CountOfSubsetSumfunc(arr, n - 1, sum - arr[n - 1], dp)
                    + CountOfSubsetSumfunc(arr, n - 1, sum, dp);

        } else {
            return dp[n][sum] = CountOfSubsetSumfunc(arr, n - 1, sum, dp);
        }
    }

}
