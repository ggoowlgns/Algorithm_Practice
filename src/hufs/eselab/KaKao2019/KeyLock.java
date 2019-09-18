package hufs.eselab.KaKao2019;

public class KeyLock {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(s.solution(key,lock));
    }
    static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;
            for(int i= 0 ; i<4 ; i++){  //돌리기
                if(matchKey(key,lock)) return true;
                rotate90Clockwise(key);//시계방향 90도 돌리기
            }


            return answer;
        }
        private boolean isKeyGood(int[][] key, int[][] lock,int i, int j){
            boolean ret = false;
            int zero_count = 0;
            for(int l_i =0; l_i<lock.length ; l_i++){
                for(int l_j =0; l_j<lock.length ; l_j++){
                    if(lock[l_i][l_j] == 0) zero_count++;
                }
            }

            for(int l_i =0; l_i<lock.length ; l_i++){
                for(int l_j =0; l_j<lock.length ; l_j++){
                    int k_i =key.length-i+l_i-1;
                    int k_j = key.length-j+l_j-1;
                    if(k_i >= 0 && k_i< key.length &&  k_j >=0 && k_j <key.length) {
                        if (lock[l_i][l_j]==0 && key[k_i][k_j] ==1){
                            zero_count--;
                        }
                        if (lock[l_i][l_j]==1 && key[k_i][k_j] ==1){
                            return false;
                        }
                    }
                }
            }
            if(zero_count ==0) ret = true;

            return ret;
        }
        private boolean matchKey(int[][] key, int[][] lock){
            boolean ret = false;
            int M = key.length;
            int N = lock.length;
            int move_count = M+N-1;
            for(int i =0; i<move_count; i++){
                for(int j =0; j<move_count;j++){
                    ret = isKeyGood(key,lock,i,j);
                    if(ret == true) return ret;
                }
            }

            return ret;

        }

        /**
         * REF : https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
         * @param a
         */
        void rotate90Clockwise(int a[][])
        {   int N = a.length;
            // Traverse each cycle
            for (int i = 0; i < N / 2; i++)
            {
                for (int j = i; j < N - i - 1; j++)
                {

                    // Swap elements of each cycle
                    // in clockwise direction
                    int temp = a[i][j];
                    a[i][j] = a[N - 1 - j][i];
                    a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                    a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                    a[j][N - 1 - i] = temp;
                }
            }
        }
    }
}
