package hufs.eselab.Kakao2018;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MuckBang {
    public static void main(String[] args) {
        Solution s= new Solution();
        int [] food_times = 	{1,2,1,2,1,1,1,1,1,1};
        int  k = 10;
        System.out.println(s.solution(food_times,k));
    }
    static class Solution {
        Queue<Map.Entry<Integer,Integer>> queue = new LinkedList<>();

        public int solution(int[] food_times, long k) {
            int answer = 0;
            long count = 0 ;
            int i = 0;
            int len =food_times.length;
            int empty_count = 0;
            while(count<k){
                i = (i%len);
                if(empty_count >= len) break;
                if (food_times[i] != 0) {
                    food_times[i]--;
                    if(food_times[i] == 0) empty_count++;
                    count++;
//                    if(count ==k) break;
                }

                i++;
            }
            if(empty_count==len) return -1;

            while (food_times[i%len] == 0) {i++; }
            return i%len+1;
//            for(int i=1 ; i<=food_times.length ; i++){
//                Map.Entry food = Map.entry(i,food_times[i-1]);
//                queue.offer(food);
//            }
//
//            //k번 먹음
//            for(int i=0 ; i<k ; i++){
//                if(!queue.isEmpty()) eatFood();
//                else break;
//            }
//
//            if(!queue.isEmpty()) answer = queue.peek().getKey();
//            else answer = -1;
//            return answer;
        }

        private void eatFood(){
            Map.Entry<Integer,Integer> food = queue.poll();
            Integer time =  food.getValue()-1;
            if(time != 0) {
                queue.offer(Map.entry(food.getKey(),food.getValue()-1));
            }

        }
    }
}
