public class GivenDiffSubsetCount {
    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 3 ,5,1,1,2,3,4,5,1};
        int diff = 1;

        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        
        int target=(sum-diff)/2;

        int count=countOfSubsetSum(arr, n, target);

        
        System.out.println(count);
    }

    public static int countOfSubsetSum(int[] arr, int n, int target) {

        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;

        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][target];

    }

}
