package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Camouflage {
    public static void main(String[] args) {
        Solution s =new Solution();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(s.solution(clothes));
    }
    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            HashMap<String,Integer> cloth = new HashMap<>();
            //걸르기
            for(String[] cl : clothes){
                //기존에 없는 종류면 만듬
                if(!cloth.containsKey(cl[1])){
                    cloth.put(cl[1], 1);
                }
                //있으면 +1
                else{
                    cloth.put(cl[1],cloth.get(cl[1])+1);    //put하면 기존거 덮어씌움 그냥 추가하는게 아님
                }
            }
            List<Integer> values = new ArrayList<>();
            answer = 1;
            for(Integer i :cloth.values()){
                answer = answer*(i+1);
            }
            answer--;

//            List<Integer> sums = get_sum(values);
//            for(Integer sum : sums) answer+= sum;

            return answer;
        }

        static List get_sum(List<Integer> values) {
            int n = values.size();
            List<Integer> sums = new ArrayList<>();
            for(int i=1; i < 1<<n; i++) {
                int ret = 1;
                for(int j=0; j<n; j++) {
                    if((i & 1<<j) != 0) {
                        ret = ret * values.get(j);
                    }
                }
                sums.add(ret);
            }
            return sums;
        }

    }
}
