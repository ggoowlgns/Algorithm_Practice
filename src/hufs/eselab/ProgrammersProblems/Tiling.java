package hufs.eselab.ProgrammersProblems;

public class Tiling {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 6;
        System.out.println(s.solution(n));
    }

    static class Solution {
        int dp[] ;
        int mod = 1000000007;
        public int solution(int n) {
            int answer = 1;
            dp = new int[n+1];
            dp[0] = 1;
            for(int i= 2;i<=n; i+=2){
                dp[i] += dp[i-2]*3 ;
                for(int j = i-4; j>=0 ;j-=2){
                    //한쪽은 4개 짜리로 넣고 다른쪽이 칸에 해당하는 만큼 또 작업
                    dp[i] += dp[j]*2;
                }
                dp[i] %=mod;
            }
            answer = dp[n];
            return answer;
//            int dp[] = new int[n+2];
//
//            dp[0] = 1;
//            dp[1] = 0;
//            dp[2] = 3;
//            for(int i = 3; i <= n; i++){
//                dp[i] = dp[i - 2] * 3;
//                for(int j = 4; j <= i; j += 2)
//                    dp[i] += dp[i - j] * 2;
//            }
//            answer = dp[n];
//            return answer;
        }
    }
}
