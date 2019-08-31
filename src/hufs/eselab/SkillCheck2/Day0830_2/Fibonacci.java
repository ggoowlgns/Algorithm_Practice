package hufs.eselab.SkillCheck2.Day0830_2;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(5));
    }
    static class Solution {
        int dp[] = new int[100001];
        public int solution(int n) {
            int answer = 0;
            Arrays.fill(dp,-1);//다 -1로 채우기, 0인경우도 있음(0)
            dp[0] = 0;
            dp[1] = 1;
            answer = fibo(n);
            return answer;
        }

        /**
         * 재귀 + dp 호출 - 20ms
         * @param n
         * @return
         */
        /*private int fibo(int n){
            int ret=0;
            //base case
            if(dp[n] != -1) return dp[n];

            ret = (fibo(n-1)+ fibo(n-2))%1234567;
            dp[n] = ret;    //insert dp

            return ret;
        }*/

        /**
         * 그냥 순수 dp
         * 훨씬 빠르다 위에 것보다 5배이상 빠름 4.8ms
         * @param n
         * @return
         */
        private int fibo(int n){
            int ret=0;
            //base case
            if(dp[n] != -1) return dp[n];

            for(int i=2; i<n ; i++) {
                dp[i] = ((dp[i - 1] + dp[i - 2]) % 1234567);
            }
            dp[n] = (dp[n - 1] + dp[n - 2]) % 1234567;
            return dp[n];
        }

    }
}
