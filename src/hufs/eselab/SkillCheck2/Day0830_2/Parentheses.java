package hufs.eselab.SkillCheck2.Day0830_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Parentheses {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution("()()"));
    }
    static class Solution {
        boolean solution(String s) {
            boolean answer = true;

            Stack st = new Stack();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '(') st.push(s.charAt(i));
                else{//')' 들어옴
                    if(!st.isEmpty()) st.pop();
                    else  return false;
                }
            }
            if(!st.isEmpty()) return false;
            return answer;
        }
    }
}
