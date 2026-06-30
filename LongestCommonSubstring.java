public class LongestCommonSubstring {
    public static void main(String[] args) {
        String l1="abcdifnvk";
        String l2="abkmvdifnkb";
    
        int n=l1.length();
        int m=l2.length();
        int[] [] dp=new int[n+1][m+1];
        int ans=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(l1.charAt(i-1)!=l2.charAt(j-1)){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                ans=Math.max(ans,dp[i][j]);

            }
        }

        System.out.println(ans);
    
    
    }
    
}
