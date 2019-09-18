package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindingPrimeNum {
    public static void main(String[] args) {
        Solution s=  new Solution();
        String numbers  = "011";
        System.out.println(s.solution(numbers));

    }
    static class Solution {
        Set<Integer> madeNumbers = new HashSet<>();
        public int solution(String numbers) {
            int answer = 0;
            List<String> single_cards = makeSingleCards(numbers);
            makeNumbers(single_cards,"");
            List<Integer> ret = new ArrayList<>();
            for(int i : madeNumbers){
                if(isNumPrime(i)){ret.add(i);
//                    System.out.println(i);
                }
            }

            answer = ret.size();
            return answer;
        }
        private int makeNumbers(List<String> left_cards,String madeNum){
            int ret = 0;
            List<String> temp = new ArrayList<>();
            for(String card : left_cards){//복사하기
                temp.add(card);
            }

            String temp_str = "";
            for (String card : left_cards) {
                temp.remove(card);
                temp_str = card +madeNum;
                madeNumbers.add(Integer.parseInt(temp_str));
                makeNumbers(temp,temp_str);
                temp.add(card);//복구

            }

            return  ret;
        }

        private List<String> makeSingleCards(String numbers){
             List<String> single_num = new ArrayList<>();

            for(int i = 0; i<numbers.length() ; i++){
                single_num.add(String.valueOf(numbers.charAt(i)));  //각각 카드 분류
            }

            return single_num;

        }
                /**
         * REF : http://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=220289619566&categoryNo=40&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search
         * @param n
         * @return
         */
        private boolean isNumPrime(int n){
            boolean result = true;
            if(n ==1 || n==0) return false;
            int end = (int)Math.sqrt(n);
            for(int i = 2; i <= end; i++) {
                if( n%i == 0) {
                    result = false;
                    break;
                    //나누어 떨어지면 더이상 소수가 아니므로 break를 걸어 for문을 끝낸다.
                } else {
                    result = true;
                }
            }
            return result;
        }
    }
}
