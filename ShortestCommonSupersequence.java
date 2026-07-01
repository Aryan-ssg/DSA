
public class ShortestCommonSupersequence {

    public static void main(String[] args) {

        String a = "abcd";
        String b = "cfd";

        int l1 = a.length();
        int l2 = b.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

            }
        }

        System.out.println((l1+l2)-dp[l1][l2]);
        StringBuilder sseq = new StringBuilder();
        while (l1 > 0 && l2 > 0) {
            if (a.charAt(l1 - 1) == b.charAt(l2 - 1)) {
                sseq.append(a.charAt(l1 - 1));
                l1--;
                l2--;
            } else {
                if (dp[l1 - 1][l2] >= dp[l1][l2 - 1]) {
                    sseq.append(a.charAt(l1 - 1));
                    l1--;

                } else {
                    sseq.append(b.charAt(l2 - 1));
                    l2--;
                }
            }

        }

        while (l1 > 0) {
            sseq.append(a.charAt(l1 - 1));
            l1--;
        }
        while (l2 > 0) {
            sseq.append(b.charAt(l2 - 1));
            l2--;
        }
        System.out.println(sseq.reverse().toString());

    }
}