

import java.util.*;

public class frogjump {
    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int[] arr = { 4, 6, 2, 8, 6, 5 };

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        

        int minenergy = jump(n - 1, k, arr, dp);
        System.out.println(minenergy);
    }

    static int jump(int ind, int k, int[] arr, int[] dp) {
        if (ind == 0) {
            return 0;
        }
        if (dp[ind] != -1)
            return dp[ind];

        // int left = jump(ind - 1, arr, dp) + Math.abs(arr[ind] - arr[ind - 1]);
        // int right = Integer.MAX_VALUE;
        // if (ind > 1) {
        // right = jump(ind - 2, arr, dp) + Math.abs(arr[ind] - arr[ind - 2]);
        // }
        int menergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            // energy=Math.min(energy,jump(ind-i,k,arr,dp)+Math.abs(arr[ind]-arr[ind-i]));
            if (ind - i >= 0) {
                int energy = jump(ind - i, k, arr, dp) + Math.abs(arr[ind] - arr[ind - i]);
                menergy = Math.min(energy, menergy);
            }
            
        }
        dp[ind] = menergy;

        return dp[ind];

    }

}
