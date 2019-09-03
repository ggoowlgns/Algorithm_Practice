package hufs.eselab.KaKao2017;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public static void main(String[] args){
        Solution s = new Solution();
        int cacheSize = 0;
        String[] cities = {"Jeju","Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "asdasd", "aSdaSd", "Jeju"};
        System.out.println(s.solution(cacheSize,cities));
    }
    static class Solution {
        Queue<String> q = new LinkedList();
        int cacheSize;
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            this.cacheSize = cacheSize;
            for(int i=0 ;i <cities.length ; i++) cities[i] = cities[i].toLowerCase();
            for(String city : cities) answer += getCity(city);
            return answer;
        }


        private int getCity(String city){
            int time = 0;
            if(q.contains(city)){
                //어디 있는지 찾고 맨뒤로 뺌
                q.remove(city);
                q.offer(city);
                time += 1;
            }else{
                if(cacheSize > q.size()) q.offer(city);
                else if(cacheSize > 0){
                    //맨앞에꺼 버리고 뒤에 넣음
                    q.poll();
                    q.offer(city);
                }
                time +=5;
            }

            return time;
        }
    }
}
