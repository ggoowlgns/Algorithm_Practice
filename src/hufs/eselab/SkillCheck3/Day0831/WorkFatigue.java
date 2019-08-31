package hufs.eselab.SkillCheck3.Day0831;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WorkFatigue {
    public static void main(String[] args){
        Solution s = new Solution();
        int n = 3;
        int[] works = {1,1};
        System.out.println(s.solution(n,works));
    }

    static class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            List<Integer> li_works = new ArrayList<>();
            for (int i : works)li_works.add(i);

            //제일 큰걸 하나씩 찾음
            int biggest = 0;
            int idx =0;

            while(n >0) {
                int num = find_biggest(li_works);
                //제일큰값이 0 보다 클 때만
                if(num == 0) break;
                idx = li_works.indexOf(num);
                li_works.set(idx, num - 1);    //-1 한값을 넣어준다.

                n--;
            }
            for(Integer i : li_works) answer += (i*i);

            return answer;
        }

        private int find_biggest(List<Integer> li){
            int biggest = -1;
            if (li.size() == 1) return li.get(0);
//            for(Integer i : li){
//                biggest = Math.max(i,biggest);
//            }
            int half = li.size()/2;
            biggest = Math.max(find_biggest(li.subList(0,half)), find_biggest(li.subList(half,li.size())));
            return biggest;
        }
    }
}
