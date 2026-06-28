public class RodCutting {
    public static void main(String[] args) {
        int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 3, 5, 6, 6, 7, 8, 10, 11 };
        int N = 8;
        int n = length.length;

        int[][] dp = new int[n + 1][N + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // System.out.println(dp[n][N]);
        System.out.println(RodCuttingFunc(length, price, N, n));

    }

    static int RodCuttingFunc(int [] length,int[] price,int n,int N){
        if(n==0 || N==0){
            return 0;
        }

        if(length[n-1]<=N){
            return Math.max(RodCuttingFunc(length,price,n,N-length[n-1])+price[n-1],RodCuttingFunc(length,price,n-1,N));
        }else{
            return RodCuttingFunc(length, price, n-1, N);
        }
    }

}
