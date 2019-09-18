package hufs.eselab.ProgrammersProblems;

import java.util.*;

public class Hash_Pro {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] s1 = {"leo", "kiki", "eden"};
        String[] s2 = {"eden", "kiki"};
        System.out.println(s.solution(	s1,s2));
    }
    static class Solution {
        public String solution(String[] participant, String[] completion) {
//            String answer = "";
//            Map<String,Integer> hash_map = new HashMap<>();
//            for(String part : participant){
//                if(!hash_map.containsKey(part))hash_map.put(part,1);
//                else hash_map.put(part, hash_map.get(part)+1);
//            }
//            for(String com : completion) hash_map.put(com, hash_map.get(com)-1);
//            for(Map.Entry<String,Integer> el : hash_map.entrySet()){
//                if(el.getValue()==1) return el.getKey();
//            }
//            return answer;

            //다른 사람 풀이
            String answer = "";
            HashMap<String, Integer> hm = new HashMap<>();

            for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
            for (String player : completion) hm.put(player, hm.get(player) - 1);

            for (String key : hm.keySet()) {
                if (hm.get(key) != 0){
                    answer = key;
                }
            }
            return answer;
        }



    }
}
