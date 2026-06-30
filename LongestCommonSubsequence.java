public class LongestCommonSubsequence {
    public static void main(String[] args) {

        String l1 = "abcfaamkl";
        String l2 = "abckjsml";

        int n = l1.length();
        int m = l2.length();
        int[][] dp = new int[n + 1][m + 1];
        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < m + 1; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                
                if(l1.charAt(i-1)!=l2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }else{
                    dp[i][j]=1+dp[i-1][j-1];
                }
            }
        }

        // int ans=lcs(l1, l2, n, m, dp);
        // System.out.println(ans);
        System.out.println(dp[n][m]);
    }

    static int lcs(String l1, String l2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (l1.charAt(n - 1) != l2.charAt(m - 1)) {
            return dp[n][m] = Math.max(lcs(l1, l2, n - 1, m, dp), lcs(l1, l2, n, m - 1, dp));

        } else {
            return dp[n][m] = 1 + lcs(l1, l2, n - 1, m - 1, dp);
        }
    }
}
