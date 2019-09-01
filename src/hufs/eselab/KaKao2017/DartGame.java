package hufs.eselab.KaKao2017;

import java.util.ArrayList;
import java.util.List;

public class DartGame {
    public static void main(String[] args){
        Solution s = new Solution();
        String dartResult = "1S*2T*3S";
        System.out.println(s.solution(dartResult));
    }
    static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            String[] res_parts =  new String[3];
            res_parts = split_parts(dartResult);
            int[] res_num = new int[3];
            for(int i=0 ;i<res_num.length;i++){//숫자,S 까지만
                res_num[i] = stringToInt(res_parts[i]);
            }

            for(int i=0; i<res_parts.length ; i++){
                char c = res_parts[i].charAt(res_parts[i].length()-1);
                switch (c){
                    case '*': {
                        if(i==0) res_num[i] = res_num[i]*2;
                        else {res_num[i] = res_num[i]*2;res_num[i-1] = res_num[i-1]*2;}
                        break;
                    }
                    case '#' : {res_num[i] = res_num[i]*(-1);break;}
                    default: break;
                }
            }
            for(int i: res_num){
//                System.out.println(i);
                answer += i;
            }


//            if(s.charAt(s.length()-1) == )
            return answer;
        }

        private int stringToInt(String num){
            char c = num.charAt(0);
            int num_ans =-1;
            int idx = -1;
            if(c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' || c=='0'){
                num_ans = Integer.parseInt(String.valueOf(c));
                idx = 1;
            }else if(num.charAt(1) == '0'){
                num_ans = Integer.parseInt("10");
                idx = 2;
            }else{
                num_ans = Integer.parseInt(String.valueOf(c));
                idx = 1;
            }
            char SorDorT = num.charAt(idx);
            switch (SorDorT){
                case 'S': {break;}
                case 'D': {num_ans = (num_ans*num_ans);break;}
                case 'T': {num_ans = (num_ans*num_ans*num_ans);break;}
                default: break;
            }

            return num_ans;


        }

        private String[] split_parts(String dartResult){
            String[] res_parts =  new String[3];
            List<Integer> num_idx = new ArrayList<>();

            int prev_idx = -5;
            for(int i=0; i<dartResult.length(); i++){   //직전게 있으면 10고려하여 뺌
                if(isNumber(dartResult.charAt(i)) && prev_idx != (i-1)) {num_idx.add(i); prev_idx=i;}
            }
            for(int i=0; i<res_parts.length;i++){   //0~2
                if(i == 2)res_parts[2] = dartResult.substring(num_idx.get(2)); //i = 2일때 끝까지
                else res_parts[i] = dartResult.substring(num_idx.get(i), num_idx.get(i+1));
            }

            return res_parts;
        }
        private boolean isNumber(char c){
            if(c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' || c=='0'){
                return true;
            }
            else return false;
        }
    }
}
