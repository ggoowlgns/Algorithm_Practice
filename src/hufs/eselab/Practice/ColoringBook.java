package hufs.eselab.Practice;

import java.util.Arrays;

public class ColoringBook {
    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 3;
        int n = 4;
        int[][] picture = {{1,1,1,1},{1,2,2,1},{2,1,1,2}};
//        int[][] picture  = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[] ret = s.solution(m,n,picture);
        for(int i : ret){
            System.out.println(i);
        }


    }
    static class Solution {
        static int[][] picture;
        static int[] dx ;
        static int[] dy;
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            this.picture = picture.clone();

            dx = new int[]{1, 0, -1, 0};
            dy = new int[]{0,1,0,-1};
            for(int i=0 ;i<picture.length; i++){
                for(int j= 0; j<picture[0].length; j++){
                    if(this.picture[i][j] != 0) {
                        int color = this.picture[i][j];
                        this.picture[i][j] = 0;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, checkOneArea(color, i,j)+1);
                        numberOfArea++;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }


        private int checkOneArea(int color, int y, int x){
            //이탈 혹은 다른색
            int ret = 0;
            int nextX = 0;
            int nextY = 0;

            for(int i= 0; i<4; i++){
                nextX = x+dx[i];
                nextY = y+dy[i];
                if(nextX>=0 && nextX < picture[0].length && nextY >=0 && nextY < picture.length) {

                    if(picture[nextY][nextX] == color){
                        picture[nextY][nextX] = 0;
                        ret += checkOneArea(color,nextY,nextX)+1;
                    }
                }
            }
            return ret;
        }
    }
}
