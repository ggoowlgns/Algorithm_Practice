package hufs.eselab.KaKao2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuildingPillar {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
//        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        s.solution(n,build_frame);

    }
    static class Solution {
        int[][] builted;
        int N;
        public int[][] solution(int n, int[][] build_frame) {
            int[][] answer = {};
            builted = new int[n+1][n+1];
            this.N = n;
            List<Building> ans = new ArrayList<>();
            for(int[] build : build_frame){
                if(build[3]==0){//삭제
                    Building temp = destoryBuild(build);
                    ans.remove(temp);
                }else {
                    if (isActPosible(build)) ans.add(new Building(build[0],build[1],build[2]));
                }
            }
            ans.sort(Comparator.reverseOrder());
            answer = new int[ans.size()][];
            int i = 0;
            for(Building a_i : ans){
                answer[i] = new int[]{ans.get(i).getX(), ans.get(i).getY(), ans.get(i).getA()};
                i++;
                System.out.println();
            }

            return answer;
        }
        private Building destoryBuild(int[] build){
            int x = build[0];
            int y = N- build[1];
            int a = build[2];
            if(builted[y][x] == 1){
                if(a== 0){//기둥
                    builted[y][x] = 0;
                    builted[y-1][x] = 0;    //한칸 위
                }
                else{
                    builted[y][x] = 0;
                    builted[y][x + 1] = 0;    //한칸 옆
                }
            }
            return new Building(x,y,a);
        }

        private boolean isActPosible(int[] build){
            boolean ret = true;
            int x = build[0];
            int y = N- build[1];
            int a = build[2];

            if (y == 5) {//기둥세움
                if(a ==0 ) {//무조건 기둥
                    builted[y][x] = 1;
                    builted[y-1][x] = 1;    //한칸 위
                }
            }else{
                if(a==0){   //기둥에서 현재 위치만 고려
                    if(builted[y][x] == 1){
                        builted[y][x] = 1;
                        builted[y-1][x] = 1;    //한칸 위
                    }
                }else if(a==1 ){//보 - 현재 위치, 오른쪽 1되면 됨
                    if(builted[y][x] == 1 || builted[y][x+1] == 1) {
                        builted[y][x] = 1;
                        builted[y][x + 1] = 1;    //한칸 옆
                    }
                }

                else if(builted[y][x] == 0) return false;
            }

            return ret;
        }

        class Building implements Comparable<Building>{
            int x;
            int y;
            int a;

            public Building(int x, int y, int a) {
                this.x = x;
                this.y = y;
                this.a = a;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }
            public int getA() {
                return a;
            }

            @Override
            public int compareTo(Building target) {
                if(this.getX() <target.getX()) return 1;
                else if (this.getX() >target.getX()){
                    return -1;
                }
                else{
                    if(this.getY() < target.getY()) return 1;
                    else if(this.getY() > target.getY()) return -1;
                }
                return 0;
            }
        }
    }
}
