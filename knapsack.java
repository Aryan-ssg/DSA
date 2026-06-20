import java.util.Arrays;

public class knapsack {
    public static void main(String[] args) {
        int w = 10;
        int[] weight = { 1,0,0,0};
        int[] value = { 2,3,3,3};
        int n = weight.length;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        System.out.println(dp[n][w]);
    }

    static int knap(int[] weight, int[] value, int n, int w, int[][] dp) {
        if (n == 0 || w <= 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (weight[n - 1] <= w) {
            return dp[n][w] = Math.max((value[n - 1] + knap(weight, value, n - 1, w - weight[n - 1], dp)),
                    knap(weight, value, n - 1, w, dp));
        } else {
            return dp[n][w] = knap(weight, value, n - 1, w, dp);
        }

    }
}
