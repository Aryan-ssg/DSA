public class MinimumSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,1};
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {

                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n][i] == true) {
                minDiff = Math.min(minDiff, sum - (2 * i));
            }

        }
        System.out.println(minDiff);

    }

    

}
