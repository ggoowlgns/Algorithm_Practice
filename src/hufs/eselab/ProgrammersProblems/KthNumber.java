package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {	1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution s = new Solution();
        for(int i : s.solution(array,commands)){
            System.out.println(i);
        }
        System.out.println(s.solution(array,commands));
    }
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }

            return answer;
        }
    }
//    static class Solution {
//        public int[] solution(int[] array, int[][] commands) {
//            int[] answer = {};
//            List<Integer> ret = new ArrayList<>();
//            for(int[] command : commands){
//                ret.add(getNum(array,command));
//            }
//
//            answer = new int[ret.size()];
//            for(int i = 0 ; i<ret.size() ; i++){
//                answer[i] = ret.get(i);
//            }
//
//            return answer;
//        }
//
//        private int getNum(int[] array, int[] command){
//            int ret = 0;
//            int i = command[0];
//            int j = command[1];
//            int k = command[2];
//            List<Integer> li_ret = new ArrayList<>();
//            for(i = i-1; i<= j-1 ; i++){
//                li_ret.add(array[i]);
//            }
//            li_ret.sort(Comparator.naturalOrder());
//            return li_ret.get(k-1);
//        }
//
//
//    }
}
