package hufs.eselab.SkillCheck3.Day0901;

import java.util.ArrayList;
import java.util.List;

public class TransformWords {
    public static void main(String[] args){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Solution s  = new Solution();
        System.out.println(s.solution(begin,target,words));
    }
    static class Solution {
        int count = 9999999;
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            List<String> li = new ArrayList<>();
            for(String word : words) li.add(word);
            transform_word(begin,target,li,0);
            answer = count;
            return answer;
        }

        private void transform_word(String begin, String target, List<String> words, int ct){
            int ret = 0;
            //base case
            if(begin == target) count = Math.min(count,ct);
            List<String> li_one_dif = new ArrayList<>();
            //단어 한개만 다른거 찾기
            List<String> left_words = new ArrayList<>();
            for(String word: words) left_words.add(word);

            for(String word : words){
                if (isOneLetterDifferendt(word, begin)) {
                    li_one_dif.add(word);
                    left_words.remove(word);
                }
            }

            for(String next : li_one_dif){
                ct++;
                transform_word(next, target, left_words ,ct);
            }

        }

        private boolean isOneLetterDifferendt(String str1, String str2){
            boolean ret = false;
            int count =0;
            for(int i=0; i<str1.length();i++){
                if(str1.charAt(i) != str2.charAt(i)) count++;
            }
            if(count==1) ret = true;
            return ret;
        }
    }
}
