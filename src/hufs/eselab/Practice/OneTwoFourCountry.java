package hufs.eselab.Practice;

import java.util.ArrayList;
import java.util.List;

public class OneTwoFourCountry {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(9));
    }
    static class Solution {
        public String solution(int n) {
            String answer = "";
            int[] num = {0,1,2,4};
            int[] dig_idx = findDigit_idx(n);
            int[] ret = new int[2];
            List<Integer> re = new ArrayList<>();
            while(dig_idx[0] != 0 && dig_idx[1] !=0) {
                ret = find_num(dig_idx);
                re.add(num[ret[0]+1]);
                dig_idx[0]--;
                dig_idx[1] = ret[1];
            }
            for(Integer i : re) answer+=i;

            return answer;
        }
        private int[] find_num(int[] dig_idx){
            int[] ret = new int[2];
            int digit = dig_idx[0];
            int idx = dig_idx[1];
            int sum = 1;
            for(int i=0; i<digit-1; i++){
                sum = sum*3;
            }
//            System.out.println(sum);
            if(sum == 1){
                ret[0] = idx / sum - 1;
                ret[1] = idx %sum;
                return ret;
            }
            //맨앞 자리
            ret[0] = idx / sum;
            //나머지
            ret[1] = idx %sum;
            if(ret[1] ==0) {ret[0]-- ; ret[1] = sum;}
            return ret;
        }

        private int[] findDigit_idx(int n){
            int[] ret = new int[2]; //[자리수, 번째]
            int sum = 3;
            int idx = 0;
            int digits = 1;
            while(sum<n){
                digits++;
                n = n - sum;
                sum = sum*3;
            }
            ret[0] = digits;
            ret[1] = n;

            return ret;
        }
    }
}
