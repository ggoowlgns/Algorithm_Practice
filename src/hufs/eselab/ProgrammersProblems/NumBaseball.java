package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.List;

public class NumBaseball {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] baseball = 	{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(s.solution(baseball));
    }
    static class Solution {
        public int solution(int[][] baseball) {
            int answer = 0;
            List<Integer> made_num = make_num();
            for(Integer num : made_num) {
                int count = 0;
                for (int[] cmd : baseball) {
                    if(is_cmd_correct(cmd,num)) count++;
                    else break;
                }
                if(count == baseball.length) answer++;
            }

            return answer;
        }

        public boolean is_cmd_correct(int[] cmd, int num){
            int[] cmd_num_by_num = new int[3];
            cmd_num_by_num[0] = cmd[0]/100;
            cmd_num_by_num[1] = (cmd[0]%100)/10;
            cmd_num_by_num[2] = (cmd[0]%10);

            int[] num_by_num = new int[3];
            num_by_num[0] = num/100;
            num_by_num[1] = (num%100)/10;
            num_by_num[2] = (num%10);

            int stricke = 0;
            int ball = 0;

            for(int i = 0 ;i<cmd_num_by_num.length ; i++){
                for(int j=0; j<num_by_num.length ; j++){
                    if(cmd_num_by_num[i]== num_by_num[j]){//일단 숫자는 맞음
                        if(i==j){//자리 까지 맞음
                            stricke++;
                            break;
                        }
                        else{
                            ball++;
                            break;
                        }
                    }
                }
            }
            if(stricke== cmd[1] && ball==cmd[2]) return true;
            else return false;



        }



        public List<Integer> make_num(){
            List<Integer> ret = new ArrayList<>();
            for(int i =1 ; i<=9;i++){
                for(int j=1; j<=9;j++){
                    for(int k=1 ; k<=9 ; k++){
                        if(k!=j && k!=i && i!=j){
                            ret.add(i*100 + j*10 + k);
                        }
                    }
                }
            }

            return  ret;
        }
    }
}
