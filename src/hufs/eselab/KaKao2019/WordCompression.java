package hufs.eselab.KaKao2019;

public class WordCompression {
    public static void main(String[] args) {
        Solution s = new Solution();
        String st = 		"xababcdcdababcdcd";
        System.out.println(s.solution(st));
    }
    static class Solution {
        public int solution(String s) {
            int answer = 1000;
//            System.out.println(compressString(s));
            for(int i=1 ;i<=s.length()/2+1 ; i++){
                answer = Math.min(answer,compressString(s,i).length());
            }

            return answer;
        }
        private String compressString(String s, int count_len){
            String ret = "";
            for(int i= 0 ;i<s.length() ; i+=count_len) {
                String subString = "";
                int count = 1;
                if(i+count_len > s.length()) subString = s.substring(i, s.length());
                else{subString = s.substring(i,i+count_len);

                    for(int j = i+count_len; j<s.length();j+=count_len){
                        if(j+count_len > s.length()) break;
                        String temp = s.substring(j,j+count_len);
                        if(temp.equals(subString)) count++;
                        else break;
                    }
                }
                if(count ==1 )ret += subString;
                else ret += (count+subString);
                i += (count-1)*count_len;
            }

//            System.out.println(ret);
            return ret;
        }
    }

}
