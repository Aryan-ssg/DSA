
public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {

        String l1 = "abcfaamkl";
        String l2 = "abckjsml";

        int n = l1.length();
        int m = l2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (l1.charAt(i - 1) != l2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
            }
        }


        int i=n;
        int j=m;
        StringBuilder lcs=new StringBuilder();
        while(i>0 && j>0){
            if(l1.charAt(i-1)==l2.charAt(j-1)){
                lcs.append(l1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i][j]==dp[i-1][j]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        System.out.println(lcs.reverse());
    }
}