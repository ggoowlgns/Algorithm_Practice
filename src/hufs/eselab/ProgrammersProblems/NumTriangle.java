package hufs.eselab.ProgrammersProblems;

public class NumTriangle {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] triangle = 	{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(s.solution(triangle));
    }
    static class Solution {
        int[][] dp;
        public int solution(int[][] triangle) {
            int answer = 0;
            this.dp = new int[triangle.length][triangle[triangle.length-1].length];
            dp[0][0]=triangle[0][0];
            for(int i = 0;i<triangle.length-1 ; i++){
                for(int j=0; j<triangle[i].length ;j++){

                    dp[i+1][j] = Math.max(dp[i][j]+triangle[i+1][j],dp[i+1][j]);
                    dp[i+1][j+1] = Math.max(dp[i][j]+triangle[i+1][j+1],dp[i+1][j+1]);
                }
            }

            for(int i : dp[triangle.length-1]){
                answer = Math.max(answer,i);
            }

            return answer;
        }
    }
}
