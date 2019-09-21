package hufs.eselab.ProgrammersProblems;

import java.util.*;

public class Carpet {
    public static void main(String[] args) {
        Solution s = new Solution();
        int brown= 8;
        int red = 1;
        int[] ret = s.solution(brown,red);
        System.out.println(""+ret[0]+", "+ret[1]);

    }
    static class Solution {
        public int[] solution(int brown, int red) {
            int[] answer = new int[2];
            int all_blocks =brown+red;

            List<HashSet<Integer>> yaksus = new ArrayList<>();
            for(int i=3; i<=all_blocks/3 ; i++ ){
                HashSet<Integer> yaksu = new HashSet(); //약수
                if(all_blocks%i ==0) {
                    yaksu.add(all_blocks/i);
                    yaksu.add(i) ;
                    if(!yaksus.contains(yaksu)) yaksus.add(yaksu);
                }
            }
            int width=0;
            int height=0;
            for(HashSet<Integer> yaksu : yaksus){
                if(yaksu.size()==1){
                    for(Integer i : yaksu){
                        width = i;
                        height = i;
                    }
                }else {
                    int idx = 0;
                    for (Integer i : yaksu) {
                        if (idx == 0) width = i;
                        else height = i;
                        idx++;
                    }
                }

                if(((width-2)*(height-2) == red))  break;

            }
            answer[0] = Math.max(width,height);
            answer[1] = Math.min(width,height);
            return answer;
        }
    }

}
