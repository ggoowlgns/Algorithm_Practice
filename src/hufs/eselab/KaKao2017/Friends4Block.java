package hufs.eselab.KaKao2017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Friends4Block {
    public static void main(String[] args){
        Solution s = new Solution();
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(s.solution(m,n,board));
    }

    static class Solution {
        int removed_block_count = 0;
        public int solution(int m, int n, String[] board) {
            int answer = -1;
            char[][] board_map = new char[m][n];

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    board_map[i][j] = board[i].charAt(j);
                }
            }

//            board_map = findFourBlocks(board_map);//없애고
            int prev_count = 0;
            while(prev_count != answer) {
                answer = prev_count;
                board_map = findFourBlocks(board_map);//없애고
                prev_count = findEmptySpace(board_map);
            }


            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    System.out.print(board_map[i][j]);
                }
                System.out.println();
            }
            return answer;
        }
        private int findEmptySpace(char[][] board){
            int ret=0;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j] == '0') ret+=1;
                }
            }
            return ret;
        }

        private char[][] findFourBlocks(char[][] board){
            List<Integer[]> removed_blocks = new ArrayList<>();
            for(int i=0; i<board.length-1; i++){
                for(int j=0; j<board[i].length-1 ; j++){
                    char c = board[i][j];
                    if(c == board[i+1][j] && c == board[i+1][j+1] && c == board[i][j+1]){
                        Integer[][] blocks = {{i,j},{i+1,j},{i,j+1},{i+1,j+1}};

                        loop:
                        for(Integer[] b : blocks){
                            for(Integer[] bl: removed_blocks){
                                if(bl[0] == b[0] && bl[1]== b[1]) continue loop;
                            }
                            removed_blocks.add(b);
                        }
                    }
                }
            }
            for(Integer[] t : removed_blocks){
                //0으로 바꿔주기
                board[t[0]][t[1]] = '0';
            }
            for(int j= board[0].length-1 ; j>=0 ; j--){
                Queue<Character> q = new LinkedList();
                for(int i = board.length-1 ; i>=0;i--){
                    if(board[i][j] != '0'){
                        q.offer(board[i][j]);
                    }
                }
                for(int i = board.length-1 ; i>=0;i--){
                    if(!q.isEmpty()){
                        board[i][j] = q.poll();
                    }else board[i][j] = '0';
                }
            }
            removed_block_count += removed_blocks.size();
            return board;
        }

    }
}
