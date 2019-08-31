package hufs.eselab.SkillCheck3.Day0831;

import java.util.ArrayList;
import java.util.List;

public class HighwayCamera {
    public static void main(String[] args){
        Solution s= new Solution();
        int[][] routes={{-20,15},{-14,-5},{-18,-13},{-5,-3}};
        System.out.println(s.solution(routes));
    }
    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;
            List<int[]> li_routes = new ArrayList<>();
            for(int[] temp : routes) li_routes.add(temp);
            List<int[]> ret = new ArrayList<>();
            answer++;
            List temp = new ArrayList();
            for(int[] t :li_routes) temp.add(t);
            loop:
            while(true){
                for(int i=0 ; i<answer ;i++){   //camera 몇번 찍는지
                    for(int[] d : li_routes) {
                        for(int j=0; j<2;j++) {
                            temp = remove_route_with_cameraLocation(temp, d[j]);
                            if(temp.size() ==0) break loop;
                        }
                    }
                }

            }
            return answer;
        }
        private List remove_route_with_cameraLocation(List<int[]> li_routes, int camera_location){
            List ret = new ArrayList();

            for(int[] temp : li_routes){
                if(temp[0]<=camera_location && camera_location<=temp[1]){
                    continue;
                }else ret.add(temp);
            }

            return ret;
        }
    }
}
