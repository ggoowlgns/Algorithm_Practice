package hufs.eselab.ProgrammersProblems;

import java.util.Arrays;

public class GymSuit {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
//        s.solution(n,lost,reserve);
        System.out.println(s.solution(n,lost,reserve));
    }
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int[] clouth_count = new int[n+1];
            Arrays.fill(clouth_count,1);
            for(int i :lost){
                clouth_count[i] -= 1;
            }
            for(int i :reserve){
                clouth_count[i] += 1;
            }


            //옷 분배
            for(int i=1 ; i <clouth_count.length; i++){
                if(clouth_count[i]==0){
                    //맨뒤
                    if(i == clouth_count.length-1) {clouth_count[i-1] -=1;clouth_count[i] +=1;}
                    else {
                        if (clouth_count[i - 1] == 2) {
                            clouth_count[i - 1] -= 1;
                            clouth_count[i] += 1;
                        } else if (clouth_count[i + 1] == 2) {
                            clouth_count[i + 1] -= 1;
                            clouth_count[i] += 1;
                        }
                    }
                }
            }

            for(int i : clouth_count){
                System.out.print(i + " ");
            }
            for(int i=1 ; i <clouth_count.length; i++){
                if(clouth_count[i]>0) answer++;
            }

            return answer;
        }
    }
}
