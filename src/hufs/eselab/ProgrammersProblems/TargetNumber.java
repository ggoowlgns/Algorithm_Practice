package hufs.eselab.ProgrammersProblems;

public class TargetNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(s.solution(numbers,target));
    }
    static class Solution {
        int count = 0;
        int target = 0;
        public int solution(int[] numbers, int target) {
            int answer = 0;
            this.target = target;
            dfs(numbers,0,0);
            answer = count;
            return answer;
        }

        public void dfs(int[] numbers,int idx ,int sum){
            //base case
            if(idx == numbers.length){
                if(target==sum)count++;
                return;
            }

            for(int i=0 ; i<2; i++){
                switch (i){
                    case 0: {
                        sum = sum + numbers[idx];
                        dfs(numbers, idx + 1, sum);
                        sum = sum - numbers[idx];
                        break;
                    }
                    case 1: {
                        sum = sum - numbers[idx];
                        dfs(numbers, idx + 1, sum);
                        sum = sum + numbers[idx];   //원상 복귀
                        break;
                    }
                }
            }

        }


        /**
         * Other Solution
         * 위보다 2배 빠름
         *
         * 되면 결과를 1로 두고 더해나감 - 아이디어 좋음 (종종 보는것 같음)
         */

        public int solution2(int[] numbers, int target) {
            int answer = 0;
            answer = dfs(numbers, 0, 0, target);
            return answer;
        }
        int dfs(int[] numbers, int n, int sum, int target) {
            if(n == numbers.length) {
                if(sum == target) {
                    return 1;
                }
                return 0;
            }
            return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
        }
    }
}
