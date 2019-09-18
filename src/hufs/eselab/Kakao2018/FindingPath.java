package hufs.eselab.Kakao2018;

import java.util.*;

public class FindingPath {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] ret = s.solution(nodeinfo);
        for(int[] t: ret ){
            for(int i : t){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    static class Solution {
        Map<Integer,int[]> trees = new HashMap<>();
        public int[][] solution(int[][] nodeinfo) {
            int[][] answer = {};
            for(int i=1; i<=nodeinfo.length ; i++){
                trees.put(i,nodeinfo[i-1]);
            }

            Set<Integer> levels = new TreeSet<>();
            for(Map.Entry<Integer,int[]> entry : trees.entrySet()){
                levels.add(entry.getValue()[1]);
            }
            List<Integer> list  = new ArrayList<>();
            for(Integer i : levels) list.add(i);
            Collections.sort(list,Collections.reverseOrder());//내림차순
            for(int i=0; i<list.size()-1 ; i++){
                int high_level = list.get(i);
                int low_level = list.get(i+1);

            }

            return answer;
        }

        public class TreeNode {
            Integer data;
            TreeNode left;
            TreeNode right;

            public TreeNode(Integer data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }

            public void setLeft(TreeNode left) {
                this.left = left;
            }

            public void setRight(TreeNode right) {
                this.right = right;
            }

            public TreeNode getLeft() {
                return left;
            }

            public TreeNode getRight() {
                return right;
            }

            public Integer getData(){
                return this.data;
            }
        }

    }
}
