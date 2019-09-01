package hufs.eselab.SkillCheck3.Day0831_1;

import javafx.util.Pair;

import java.util.*;

public class Delivery {
    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 5;
        int[][] road = {{1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}};
        int K = 3;
        //4개 1포함

        System.out.println(s.solution(N, road, K));
    }

    /**
     * path : 각 길에 대한 값들 -else 0
     * dist : 1에서 갈수 잇는 최단 경로
     */
    static class Solution {
        int path[][];
        int dist[];
        int N;

        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            path = new int[N + 1][N + 1];
            dist = new int[N + 1];
            this.N = N;
            Arrays.fill(dist, 9999);
            dist[1] = 0;  //1에서 1로 가는건 0
            List<Integer> left = new ArrayList<Integer>();
            for (int i = 0; i < road.length; i++) {
                //양방향 동일
                path[road[i][0]][road[i][1]] = road[i][2];
                path[road[i][1]][road[i][0]] = road[i][2];
            }


            for(int i=2; i<=N;i++) left.add(i); //남은 것들 넣기

            dijkstra(1,left,0);

            for (int i : dist) {
                if(i<=K) answer++;
            }
            return answer;
        }

        private void dijkstra(int start, List<Integer> left, int time){
            List<Integer> left_temp = new ArrayList<>();
            for(int i : left) left_temp.add(i); //복제

            for(int n: left){
                if(path[start][n] != 0) {
                    dist[n] = Math.min(dist[n], path[start][n] + time);
                    left_temp.remove(left_temp.indexOf(n));
                    dijkstra(n,left_temp,path[start][n] + time);
                    left_temp.add(n);
                }

            }
        }



    }
}

