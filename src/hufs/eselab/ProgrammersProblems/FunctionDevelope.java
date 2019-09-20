package hufs.eselab.ProgrammersProblems;

import java.util.*;

public class FunctionDevelope {
    public static void main(String[] args) {
        int[] pro = {55,90,30,55,90,30};
        int[] spe = {5,1,10,55,90,30};
        int[] res = Solution.solution(pro,spe);
        for(int i : res) System.out.println(i);
    }
    static class Solution {
        public static int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            Integer[] need_time = get_need_time(progresses, speeds);
            List<Integer> need_time_li = Arrays.asList(need_time);
            List<Integer> ans_li = new ArrayList<>();
            for(int i = 0 ; i< need_time_li.size() ; i++){
                int count = 1;
                if(need_time_li.get(i)!=999) {
                    for (int j = i + 1; j < need_time_li.size(); j++) {
                        if (need_time_li.get(i) >= need_time_li.get(j)) {
                            need_time_li.set(j, 999);
                            count++;
                        }else break;
                    }
                    ans_li.add(count);
                }
            }
            answer = new int[ans_li.size()];
            for(int i=0; i<answer.length;i++) answer[i] = ans_li.get(i);

            return answer;
        }
        public static Integer[] get_need_time(int[] progresses, int[] speeds){
            Integer[] ret = new Integer[progresses.length];
            for(int i=0; i<progresses.length ; i++){
                if((100-progresses[i])%speeds[i] != 0){ //나눴을때 나머지 있음
                    ret[i] = (100-progresses[i])/speeds[i] +1;
                }else{// 나머지 없을때
                    ret[i] = (100-progresses[i])/speeds[i];
                }
            }

            return ret;
        }
    }
}
