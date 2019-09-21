package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 제일 큰수를 시작으로 --로 찾음 -> 효율적이게 보이지는 x
 */
public class HIndex {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[] citations = {22,42};
        System.out.println(s.solution(citations));
    }
    static class Solution {
        int[] citations;
        public int solution(int[] citations) {
            int answer = 0;
            this.citations = citations;
            List<Integer> li = new ArrayList<Integer>();
            for(int temp : citations) li.add(temp);

            Collections.sort(li, Collections.reverseOrder());

            for(Integer i : li) System.out.println(i);
            for(int i=li.get(0); i>=0;i--){ //가장 큰수부터

                if(is_value_hindex(i)) answer = Math.max(answer,i);
            }
            return answer;
        }

        public boolean is_value_hindex(int pivot){
            boolean ret = false;
            int count = 0;
            for(int temp : citations){
                if(temp >= pivot) count++;
            }
            if(count >= pivot) ret = true;

            return ret;
        }


    }
}
