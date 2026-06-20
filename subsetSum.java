public class subsetSum {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9};
        int target = 44;
        int n=nums.length;
        Boolean [][] dp=new Boolean[n+1][target+1];
        for(int i=0;i<target+1;i++){
            dp[0][i]=false;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }

        System.out.println(dp[n][target]);

    }

    static Boolean subsetFunc(int [] nums, int n,int target,Boolean[][] dp){
        if(target==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        if(nums[n-1]<=target){
            return dp[n][target]=subsetFunc(nums,n-1,target-nums[n-1],dp)||subsetFunc(nums,n-1,target,dp);
        }else{
            return dp[n][target]=subsetFunc(nums,n-1,target,dp);
        }


    }

}
