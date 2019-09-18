package hufs.eselab.ProgrammersProblems;

import java.util.*;

public class MockTest {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};
        int[] ret = s.solution(answers);
        for(int i : ret) System.out.println(i);
    }

    static class Solution {
        class PersonAnswer implements Comparable<PersonAnswer>{
            private int per_num;
            private int correct_count;

            public PersonAnswer(int per_num, int correct_count) {
                this.per_num = per_num;
                this.correct_count = correct_count;
            }

            public int getPer_num() {
                return per_num;
            }

            public int getCorrect_count() {
                return correct_count;
            }
            public boolean isAnsCountSame(PersonAnswer target){
                if(this.getCorrect_count() == target.getCorrect_count())return true;
                else return false;
            }

            @Override
            public int compareTo(PersonAnswer target) {
                if(this.getCorrect_count() <target.getCorrect_count())return 1;
                else if(this.getCorrect_count() >target.getCorrect_count())return -1;
                else return 0;
            }
        }
        public int[] solution(int[] answers) {
            int[] answer = {};
            int[] per1 = {1,2,3,4,5};
            int[] per2 = {2,1,2,3,2,4,2,5};
            int[] per3 = {3,3,1,1,2,2,4,4,5,5};

            PersonAnswer personAnswer1 = new PersonAnswer(1,count_correct_answers(answers,per1));
            PersonAnswer personAnswer2 = new PersonAnswer(2,count_correct_answers(answers,per2));
            PersonAnswer personAnswer3 = new PersonAnswer(3,count_correct_answers(answers,per3));
            List<PersonAnswer> an_li = new ArrayList<>();
            an_li.add(personAnswer1);
            an_li.add(personAnswer2);
            an_li.add(personAnswer3);
            Collections.sort(an_li);
            List<Integer> ret = new ArrayList<>();
            Set<Integer> set = new TreeSet<>();
            for(int i=0; i<an_li.size()-1 ; i++){
                if (an_li.get(i).isAnsCountSame(an_li.get(i + 1))) {
                    set.add(an_li.get(i).getPer_num());
                    set.add(an_li.get(i+1).getPer_num());
                }
                else {set.add(an_li.get(i).getPer_num());break;}
            }
            answer = new int[set.size()];
//            for(int i=0; i<answer.length ; i++){
//                answer[i] = set.
//            }
            int idx=0;
            for(Integer i : set){
                answer[idx] = i;
                idx++;
            }
            return answer;
        }

        private int count_correct_answers(int[] answers, int[] per_answers){
            int count = 0;
            int per_ans_len = per_answers.length;
            for(int i=0; i<answers.length; i++){
                int idx = i%per_ans_len;
                if(answers[i]== per_answers[idx]) count++;
            }
            return count;
        }
    }
}
