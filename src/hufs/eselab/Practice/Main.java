package hufs.eselab.Practice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};

        int res[] = s.solution(v);
        System.out.println("["+res[0]+","+res[1]+"]");
    }

    static class Solution {
        public int[] solution(int[][] v) {
            int[] answer = new int[2];
            List<Integer> x = new ArrayList<Integer>();
            List<Integer> y = new ArrayList<Integer>();
            for(int i=0; i< v.length ; i++){
                if(x.contains(v[i][0])) x.remove(x.indexOf(v[i][0]));
                else x.add(v[i][0]);

                if(y.contains(v[i][1])) y.remove(y.indexOf(v[i][1]));
                else y.add(v[i][1]);
            }
            answer[0] = x.get(0);
            answer[1] = y.get(0);

            return answer;
        }
    }
}
