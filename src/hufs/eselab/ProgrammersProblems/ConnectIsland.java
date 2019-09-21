package hufs.eselab.ProgrammersProblems;

import java.util.ArrayList;
import java.util.List;

public class ConnectIsland {
    public static void main(String[] args) {
        Solution s =new Solution();
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(s.solution(n,costs));
    }
    static class Solution {
        public int solution(int n, int[][] costs) { // kruskal algorithm
            int answer = 0;
            int[][] link = new int[n][n];
            int minCost = costs[0][2];
            int minIsland1 = costs[0][0], minIsland2 = costs[0][1];

            List<Boolean> visited = new ArrayList<>();
            for(int i = 0; i < n; i++)
                visited.add(false);

            for(int i = 0; i < costs.length; i++) {
                link[costs[i][0]][costs[i][1]] = costs[i][2];
                link[costs[i][1]][costs[i][0]] = costs[i][2];

                if(costs[i][2] < minCost) { // select first island
                    minCost = costs[i][2];
                    minIsland1 = costs[i][0];
                    minIsland2 = costs[i][1];
                }
            }

            while(visited.contains(false)){
                answer += minCost;
                visited.set(minIsland1, true);
                visited.set(minIsland2, true);
                minCost = (int)1e9; //가장 작은값

                for(int i = 0; i < n; i++) {
                    if(visited.get(i) == true) {
                        for(int j = 0; j < n; j++) {
                            if(link[i][j] != 0 && visited.get(j) == false && minCost > link[i][j]) {
                                minCost = link[i][j];
                                minIsland1 = i;
                                minIsland2 = j;
                            }
                        }
                    }
                }
            }

            return answer;
        }

        /*int[] isChecked;
        int[][] costs;
        public int solution(int n, int[][] costs) {
            int answer = 999;
            this.costs = costs;
            for(int i =0; i<n; i++){

                isChecked = new int[n];
                isChecked[i] = 1;
                answer = Math.min(answer,build_all(i,0));//i에서 시작했을때 최단
            }

            return answer;
        }
        public int build_all(int start,int sum){
            int ret=9999;
            int cot =0;
            for(int i : isChecked){
                if(i==1) cot++;
            }
            if(cot==isChecked.length) return sum;

            //dfs -> X
            *//*
            for(int i=0 ;i<isChecked.length;i++){
                if(isChecked[i]!= 1) { //가지 않은곳
                    int cost = build_bridge(start,i);
                    if(cost ==0) continue;
                    else {
                        isChecked[i] = 1;
                        sum += cost;
                        ret = Math.min(ret,build_all(i,sum));
                        sum -= cost;
                        isChecked[i] = 0;
                    }
                }
            }*//*



            return ret;
        }

        public int build_bridge(int i1, int i2){
            int ret = 0;
            //base case 같은상황은 무시
            if(i1==i2) return 0;

            for(int[] bridge : costs){
                if(((bridge[0]==i1) ||(bridge[0]==i2))  &&( (bridge[1]==i1) ||(bridge[1]==i2))){
                    ret= bridge[2];
                    return ret;
                }
            }
            return ret;

        }*/
    }
}
