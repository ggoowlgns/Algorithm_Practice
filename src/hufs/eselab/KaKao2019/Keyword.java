package hufs.eselab.KaKao2019;

import java.util.ArrayList;
import java.util.List;

public class Keyword {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] ans = s.solution(words,queries);
        for(int i: ans) System.out.println(i);
        System.out.println();
    }
    static class Solution {
        public int[] solution(String[] words, String[] queries) {
            int[] answer = {};
            List<Integer> res = new ArrayList<>();

            for(String q : queries){
                res.add(howManyMatchingWords(q,words));
            }

            //테스트 출력
//            for(Integer i : res) System.out.println(i);
            answer = new int[queries.length];
            for(int i= 0 ;i< queries.length;i++){
                answer[i] = res.get(i);
            }
            return answer;
        }

        private int howManyMatchingWords(String q, String[] words){
            int count = 0;
            for(String word : words){
                if(isWordMatching(word,q)) count++;
            }
            return count;
        }

        private boolean isWordMatching(String word, String q){
            boolean ret = false;
            if(word.length() != q.length()) return ret;
            int i;
            int difference = 0;
            if(!(q.charAt(0) == '?')) q = q.replaceAll("[?]", "");
            else{
                int q_len = q.length();
                String temp = q.replaceAll("[?]", "");
                int q_len_after = temp.length();
                difference = q_len- q_len_after;
            }

            for(i =difference ;i< q.length(); i++){
                if((word.charAt(i) == q.charAt(i) )) continue;
                else return ret;

            }
            ret = true;
            return ret;
        }
    }
}
