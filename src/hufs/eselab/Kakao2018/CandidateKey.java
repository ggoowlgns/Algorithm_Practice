package hufs.eselab.Kakao2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CandidateKey {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {
        "300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {
        "600", "apeach", "music", "2"}};

        System.out.println(s.solution(relation));
    }
    static class Solution {
        static List<List<Integer>> ret = new ArrayList<>();
        public int solution(String[][] relation) {
            int answer = 0;
            int column_len = relation[0].length;
            makeIndexes(column_len);
            List<List<Integer>> res = new ArrayList<>();
            for(List<Integer> l : ret){
                String[] tuples = new String[relation.length];
                if(isPrevCandidateIncluded(l,res)) continue;
                for(Integer j : l){
//                    System.out.print(" "+i);
                    for(int i = 0;i<relation.length ; i++){
                        tuples[i] += relation[i][j];
                    }
                }
                if(isCandidate(tuples) ) res.add(l);

//                System.out.println();
            }
//            for(List<Integer> l : res ){
//                for(Integer i : l ) System.out.print(i);
//                System.out.println();
//            }
            answer = res.size();
            return answer;
        }

        //포함하고 있으면 true
        public boolean isPrevCandidateIncluded(List<Integer> l, List<List<Integer>> already){
            for(List<Integer> al :already){
                if(l.containsAll(al)) return true;
            }
            return false;
        }
        public boolean isCandidate(String[] tuples){

            Set<String> set = new HashSet<>();
            for(String tu: tuples) set.add(tu);
            if(set.size() == tuples.length) return true;
            else return false;

        }

        public void makeIndexes(int column_len){
            int[] arr = new int[column_len];
            for(int i=0 ; i< column_len; i++){
                arr[i] = i;
            }
            bit(arr,column_len);
            return ;
        }
        static void bit(int[] arr, int n) {
            for(int i=0; i < 1<<n; i++) {
                List<Integer> temp = new ArrayList<>();
                for(int j=0; j<n; j++) {
                    if((i & 1<<j) != 0)
                        temp.add(arr[j]);
//                        System.out.print(arr[j] + " ");
                }
                ret.add(temp);
//                System.out.println();
            }
        }


    }
}
