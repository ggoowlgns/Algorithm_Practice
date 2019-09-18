package hufs.eselab.KaKao2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NewsClustering {
    public static void main(String[] args){
        Solution s = new Solution();
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        System.out.println(s.solution(str1,str2));
    }
    static class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            float ans = 0;
            //공백, 특문 제거
            str1 = filter_str(str1);
            str2 = filter_str(str2);

            //대문자로 통일
            str1 = str1.toUpperCase();
            str2 = str2.toUpperCase();
            List<String> li_str1 = split_str(str1);
            List<String> li_str2 = split_str(str2);
            float intersection_value = find_intersection(li_str1,li_str2);
//            int union_value = find_union(li_str1,li_str2);
            float union_value = li_str1.size()+li_str2.size() - intersection_value;
            if(union_value == 0) answer = 65536;
            else {
                System.out.println("uniton :" + union_value);
                ans = intersection_value / union_value;
                answer = (int) (ans * 65536);
            }
            return answer;
        }
        private int find_union(List<String> li_str1, List<String> li_str2) {
            List<String> ret = new ArrayList<>();

            //교집합 그대로 하고
            List<String> li_str2_clone = new ArrayList<>();
            for(String str2: li_str2) li_str2_clone.add(str2);
            for(String str1: li_str1){
                if (li_str2_clone.contains(str1)) {li_str2_clone.set(li_str2_clone.indexOf(str1),""); ret.add(str1);}
            }

            //남은거 다 넣어줌
            for(String str2 : li_str2_clone){
                if(!str2.equals("")) ret.add(str2);
            }
            System.out.println("uniton :"+ret.size());
            return ret.size();
        }
        private int find_intersection(List<String> li_str1, List<String> li_str2){
            List<String> ret = new ArrayList<>();
            //li_str2 복제 해야함 - call by ref
            List<String> li_str2_clone = new ArrayList<>();
            for(String str2: li_str2) li_str2_clone.add(str2);

            for(String str1: li_str1){
                if (li_str2_clone.contains(str1)) {li_str2_clone.set(li_str2_clone.indexOf(str1),""); ret.add(str1);}
            }
            System.out.println("inter : "+ret.size());
            return ret.size();
        }
        //정렬해줌
        private List<String> split_str(String str){
            List<String> ret = new ArrayList<>();
            for(int i = 0; i<str.length()-1 ; i++){
                //공백이 들어있으면 무시
                if(str.substring(i,i+1).equals(" ") || str.substring(i+1,i+2).equals(" ")) continue;
                ret.add(str.substring(i,i+2));
            }
//            for(String s : ret) System.out.println(s);
            Collections.sort(ret);
            return ret;
        }

        private String filter_str(String str){
            String ret = "";
//            ret = str.replaceAll("[^A-Za-z0-9]","");
            //모두 한칸 공백으로 대체
            ret = str.replaceAll("[^A-Za-z]"," ");
            return ret;
        }
    }
}
