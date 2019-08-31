package hufs.eselab.SkillCheck2.Day0830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//시간 문제로 21.9/50
public class JadenCase {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        System.out.println(s.solution("3people unFollowed me"));
    }

    static class Solution{
        public String solution(String s) {
            String answer = "";
            List<String> li_s = Arrays.asList(s.split(" "));
            for(String temp_s : li_s){
                String ret_s = change_to_Jadencase(temp_s);
//                li_ret.add(ret_s);
                answer += ret_s;
                answer += " ";
            }

            return answer.substring(0,answer.length()-1);
        }
        private String change_to_Jadencase(String s){
            String ret = "";
            //첫글자
            char temp_c = s.charAt(0);
            List<String> li_ret = new ArrayList<String>();
            if(check_is_somonja(temp_c)) li_ret.add(String.valueOf(change_soToDa(temp_c)));
            else li_ret.add(String.valueOf(temp_c));

            //나머지
            for(int i=1; i<s.length() ; i++){
                temp_c = s.charAt(i);
                if(check_is_capital(temp_c)){
                    li_ret.add(String.valueOf(change_daToSo(temp_c)));
                }else li_ret.add(String.valueOf(temp_c));
            }

            //li_ret String으로 만들기
            for(String temp_s : li_ret){
                ret += temp_s;
            }
            return ret;
        }
        private char change_daToSo(char c){
            switch (c){
                case 'A': return 'a';
                case 'B': return 'b';
                case 'C': return 'c';
                case 'D': return 'd';
                case 'E': return 'e';
                case 'F': return 'f';
                case 'G': return 'g';
                case 'H': return 'h';
                case 'I': return 'i';
                case 'J': return 'j';
                case 'K': return 'k';
                case 'L': return 'l';
                case 'M': return 'm';
                case 'N': return 'n';
                case 'O': return 'o';
                case 'P': return 'p';
                case 'Q': return 'q';
                case 'R': return 'r';
                case 'S': return 's';
                case 'T': return 't';
                case 'U': return 'u';
                case 'V': return 'v';
                case 'W': return 'w';
                case 'X': return 'x';
                case 'Y': return 'y';
                case 'Z': return 'z';
                default: return c;
            }
        }

        private char change_soToDa(char c){
            switch (c){
                case 'a': return 'A';
                case 'b': return 'B';
                case 'c': return 'C';
                case 'd': return 'D';
                case 'e': return 'E';
                case 'f': return 'F';
                case 'g': return 'G';
                case 'h': return 'H';
                case 'i': return 'I';
                case 'j': return 'J';
                case 'k': return 'K';
                case 'l': return 'L';
                case 'm': return 'M';
                case 'n': return 'N';
                case 'o': return 'O';
                case 'p': return 'P';
                case 'q': return 'Q';
                case 'r': return 'R';
                case 's': return 'S';
                case 't': return 'T';
                case 'u': return 'U';
                case 'v': return 'V';
                case 'w': return 'W';
                case 'x': return 'X';
                case 'y': return 'Y';
                case 'z': return 'Z';
                default: return c;
            }
        }

        private boolean check_is_somonja(char c){
            switch (c){
                case 'a': return true;
                case 'b': return true;
                case 'c': return true;
                case 'd': return true;
                case 'e': return true;
                case 'f': return true;
                case 'g': return true;
                case 'h': return true;
                case 'i': return true;
                case 'j': return true;
                case 'k': return true;
                case 'l': return true;
                case 'm': return true;
                case 'n': return true;
                case 'o': return true;
                case 'p': return true;
                case 'q': return true;
                case 'r': return true;
                case 's': return true;
                case 't': return true;
                case 'u': return true;
                case 'v': return true;
                case 'w': return true;
                case 'x': return true;
                case 'y': return true;
                case 'z': return true;
                default: return false;
            }
        }
        private boolean check_is_capital(char c){
            switch (c){
                case 'A': return true;
                case 'B': return true;
                case 'C': return true;
                case 'D': return true;
                case 'E': return true;
                case 'F': return true;
                case 'G': return true;
                case 'H': return true;
                case 'I': return true;
                case 'J': return true;
                case 'K': return true;
                case 'L': return true;
                case 'M': return true;
                case 'N': return true;
                case 'O': return true;
                case 'P': return true;
                case 'Q': return true;
                case 'R': return true;
                case 'S': return true;
                case 'T': return true;
                case 'U': return true;
                case 'V': return true;
                case 'W': return true;
                case 'X': return true;
                case 'Y': return true;
                case 'Z': return true;
                default: return false;
            }
        }


    }
}
