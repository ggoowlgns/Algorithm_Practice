package hufs.eselab.KaKao2019;

public class BracketCorrect {
    public static void main(String[] args) {
        Solution s = new Solution();
        String p = "()))((()";
        System.out.println(s.solution(p));
    }
    static class Solution {
        public String solution(String p) {
            String answer = "";

            answer = makeCorrectBracket(p);
            return answer;
        }
        private String makeCorrectBracket(String w){
            if(w.equals("")) return "";
            // 0 -u , 1- v
            String[] ret = seperateBracket(w);
            String u = ret[0];
            String v = ret[1];
            String res = "";
            if(isBracketCorrect(u)) {res = u + makeCorrectBracket(v);}
            else{
                res += "(";
                res += makeCorrectBracket(v);
                res += ")";
                String temp = u.substring(1,u.length()-1);
                temp = temp.replaceAll("\\(", "0");
                temp = temp.replaceAll("\\)", "(");
                temp = temp.replaceAll("0", ")");
                res += temp;
            }
            return res;


        }

        private boolean isBracketCorrect(String s){
            int sum = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '(') sum++;
                else if(s.charAt(i) == ')'){
                    if(sum <=0)return false;
                    else sum --;
                }
            }
            if(sum ==0) return true;
            else return false;
        }

        private String[] seperateBracket(String w){
            String u = "";
            String v = "";
            for(int i= 2; i<=w.length(); i+=2){
                if(isBracketBalance(w.substring(0,i))){ u =w.substring(0,i); v = w.substring(i,w.length());break;}
            }

            String[] ret = {u,v};
            return ret;
        }

        private boolean isBracketBalance(String w){
            int leftCnt = 0;
            int rightCnt  =0;
            int fromIndex = -1;
            /**
             * REF : https://goni9071.tistory.com/6
             */
            while ((fromIndex = w.indexOf("(", fromIndex + 1)) >= 0) {
                leftCnt++;
            }
            while ((fromIndex = w.indexOf(")", fromIndex + 1)) >= 0) {
                rightCnt++;
            }
            if(leftCnt== rightCnt) return true;
            else return false;

        }
    }
}
