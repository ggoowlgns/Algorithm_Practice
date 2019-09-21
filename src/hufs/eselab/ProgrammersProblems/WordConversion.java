package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.List;

public class WordConversion {
    public static void main(String[] args) {
        Solution s = new Solution();
        String begin="hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(s.solution(begin,target,words));
    }
    static class Solution {
        public int[] dp={};
        public String[] words={};
        public String target="";
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            dp = new int[words.length];//0이면 안간것 1이면 갔던것
            this.words = words;
            this.target = target;
            answer = dfss(begin,0);
            if(answer==9999) answer=0;
            System.out.println(answer);
            return answer;
        }

        public int dfss(String begin,int count){
            List<String> changable_words = new ArrayList<>();
            int ret = 9999;
            //base case 도달했을때
            if(target==begin) return count;

            for(int i =0 ; i<words.length ; i++){
                if((dp[i]==0) && is_word_changable(begin,words[i])){
                    dp[i] = 1;
                    changable_words.add(words[i]);
                    ret = Math.min(dfss(words[i],count+1),ret);
                    dp[i] = 0;
                }
            }
            if(changable_words.isEmpty()) return 9999;//없으면 0 말짱 도로묵

//            for(String word : changable_words){
//                ret = Math.min(dfs(word,count+1),ret);
//            }

            return ret;
        }


        public boolean is_word_changable(String word, String com){
            boolean ret = false;
            char[] word_char = word.toCharArray();
            char[] com_char = com.toCharArray();
            int count = 0;
            for(int i = 0; i<word_char.length ; i++){
                if(word_char[i] == com_char[i]) count++;
            }
            if(count==(word.length()-1)) ret = true;

            return ret;
        }
    }
}
