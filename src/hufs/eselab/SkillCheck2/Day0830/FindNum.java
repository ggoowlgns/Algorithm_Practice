package hufs.eselab.SkillCheck2.Day0830;

import java.util.ArrayList;
import java.util.List;

public class FindNum {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        System.out.println(s.solution(15));
    }

    static class Solution{
        public int solution(int n) {
            int answer = 0;
            int n_count_one = 0;
            n_count_one = count_one(n);
            int ans_count_one = 0;
            while(ans_count_one!=n_count_one){
                n++;
                ans_count_one = count_one(n);
            }
            answer = n;


            return answer;
        }
        private int count_one(int n){
            String bi_n = Integer.toBinaryString(n);
            List<Integer> bi_n_li = new ArrayList<Integer>();
            for(int i=0; i<bi_n.length(); i++){
                bi_n_li.add(Integer.parseInt(String.valueOf(bi_n.charAt(i))));
            }
            int count = 0;
            for(Integer i : bi_n_li){
                if(i ==1) count++;
            }
            return count;
        }

    }
}
