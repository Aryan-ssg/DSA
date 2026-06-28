public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = { 1, 2, 3, 4, 5 };
        int[] value = { 3, 2, 4, 5, 3 };
        int capacity = 10;

        int n = weight.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {

                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][capacity]);
    }

}
