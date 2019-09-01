package hufs.eselab.KaKao2017;

public class SecreteMap {
    public static void main(String[] args){
        Solution s = new Solution();
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};
        String[] ans = s.solution(n,arr1,arr2);
        for(String st : ans){
            System.out.println(st);
        }
    }
    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String[] str_arr1 = new String[n];
            String[] str_arr2 = new String[n];
            for(int i=0; i<n; i++){
                str_arr1[i] = makeMap(arr1[i],n);
                str_arr2[i] = makeMap(arr2[i],n);
            }
            for(int i=0 ; i<n; i++){// str_arr idx
                String temp = "";
                for(int j=0; j<n ; j++) {   //str_arr[i] idx
                    if (str_arr1[i].charAt(j) == ' ' && str_arr2[i].charAt(j) == ' ') temp+=" ";
                    else temp+="#";
                }
                answer[i] =temp;
            }

            return answer;
        }

        private String makeMap(int num,int n){
            String ret = "";
            for(int i =n-1; i>=0 ;i--){
                int di=1;
                for(int j=0; j<i ;j++){//2^n 만들기
                    di = di*2;
                }
                if((int)num/di == 1) ret +="#";
                else ret += " ";
                num = num%di;
            }
            return ret;
        }
    }
}
