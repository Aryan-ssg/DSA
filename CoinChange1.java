public class CoinChange1 {
    public static void main(String[] args) {
        
        int [] coins={1,2,3,4,5};
        int sum=5;
        int n =coins.length;
        int[][] dp=new int[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){

                if(coins[i-1]<=j){
                    dp[i][j]= dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
    
}
