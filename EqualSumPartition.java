public class EqualSumPartition {

    public static void main(String[] args) {

        int[] arr = { 4, 8,4,3};
        int sum = 0;
        int n = arr.length;

        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0) {
            System.out.println("fals");
        } else {
            int target = sum / 2;
            Boolean[][] dp = new Boolean[n + 1][target + 1];
            for (int i = 0; i < target + 1; i++) {
                dp[0][i] = false;
            }
            for (int i = 0; i < n + 1; i++) {
                dp[i][0] = true;
            }

            for(int i=1;i<n+1;i++){
                for(int j=1;j<target+1;j++){
                    if(arr[i-1]<=j){
                        dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            
            System.out.println(dp[n][target]);
            // System.out.println(equalSumPartfunc(arr, target, arr.length, dp));
        }
    }

    static boolean equalSumPartfunc(int[] arr, int target, int n, Boolean[][] dp) {

        if (target == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (dp[n][target] != null) {
            return dp[n][target];
        }
        if (arr[n - 1] <= target) {
            return dp[n][target] = equalSumPartfunc(arr, target - arr[n - 1], n - 1, dp)
                    || equalSumPartfunc(arr, target, n - 1, dp);
        } else {
            return dp[n][target] = equalSumPartfunc(arr, target, n - 1, dp);
        }
    }
}
