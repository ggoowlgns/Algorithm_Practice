package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LifeBoat {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[] people = {70,80,50,50,30,20,10,5};
        int limit = 100;
        System.out.println(s.solution(people,100));
    }
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            ArrayList<Integer> people_li = new ArrayList<>();
            for(int p  : people) people_li.add(p);
            Collections.sort(people_li,Collections.reverseOrder());

            List<Integer> moved_people = new ArrayList<>();

            int boat_count = 0;
            //다 넘어가지 않은이상
            while((moved_people.size()!=people.length) && !people_li.isEmpty()){
                int next_val = people_li.get(0);
                int left_weight = limit - next_val;
                List<Integer> more_people = new ArrayList<>();
                int last_idx = people_li.size()-1;
                while((left_weight-people_li.get(last_idx))>=0 && (people_li.indexOf(next_val)<last_idx)){
                    more_people.add(people_li.get(last_idx));
                    left_weight = left_weight- people_li.get(last_idx);
                    last_idx--;
                }

                //people_li에서 삭제, moved에 넣기
                for(Integer temp : more_people) {
                    people_li.remove(people_li.indexOf(temp));
                    moved_people.add(temp);
                }
                people_li.remove(people_li.indexOf(next_val));
                moved_people.add(next_val);

                boat_count++;
            }

            answer = boat_count;

            return answer;
        }
    }
}
