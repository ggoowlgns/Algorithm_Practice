package hufs.eselab.SkillCheck3.Day0901;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoxingSorting {
    public static void main(String[] args){
        int[][] result = {{4,3},
                        {4,2},
                        {3,2},
                        {1,2},
                        {2,5}};
        int n = 5;
        Solution s = new Solution();
        //2
        System.out.println(s.solution(n,result));
    }
    static class Solution {
        int count = 0;
        int[] sorted;
        public int solution(int n, int[][] results) {
            int answer = 0;
            int[] num_count = new int[n+1];
            sorted = new int[n+1];
            //각 숫자가 몇개인지 넣기
            for(int[] comp : results){
                num_count[comp[0]]++;
                num_count[comp[1]]++;
            }

            sorting(n,num_count , results);


            return answer;
        }

        private void sorting(int n,int[] num_count, int[][] results){
            List<Integer> pick_num = new ArrayList<>();
            //순서를 정할수 있는 것들 넣기
            for(int i=1 ; i<n+1;i++){
                if(num_count[i] >= n-1) pick_num.add(i);
            }


            for(int num : pick_num){
                results = find_place(results,num);
            }

            num_count = new int[n+1];
            for(int[] comp : results){
                num_count[comp[0]]++;
                num_count[comp[1]]++;
            }

            sorting(n,num_count,results);

        }

        //자리 찾기
        private int[][] find_place(int[][] result, int boxer_num){
            int win_count = 0;
            int lose_count = 0;
            int[][] res = new int[result.length][2];
            for(int i = 0; i<result.length; i++){
                if(result[i][0] == boxer_num) win_count++;
                else if(result[i][1] == boxer_num) lose_count++;
                else res[i] = result[i];
            }
            sorted[lose_count+1] = boxer_num;
            count++;

            //남은 부분 return
            return res;
        }
    }
}
