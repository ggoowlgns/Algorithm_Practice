package hufs.eselab.SkillCheck3.Day0831_1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_PQ {
    static class Element implements Comparable<Element> {
        private int index;
        private int distance;

        Element(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        public int compareTo(Element o) {
            return distance <= o.distance ? -1 : 1;
        }
    }


    public static class dijkstraTest05 {

        static boolean[] visit;
        static int[] dist;
        static int[][] ad;
        static int nE, nV;
        static final int inf = 100000;


        public static void ssp(int start) {
            PriorityQueue<Element> q = new <Element>PriorityQueue();
            dist[start] = 0;
            q.offer(new Element(start, dist[start]));

            while (!q.isEmpty()) {
                int cost = q.peek().getDistance();
                int here = q.peek().getIndex();
                q.poll();

                if (cost > dist[here])
                    continue;

                System.out.print(here);

                for (int i = 0; i <= nV; i++) {
                    if (ad[here][i] != 0 && dist[i] > dist[here] + ad[here][i]) {
                        dist[i] = dist[here] + ad[here][i];
                        q.offer(new Element(i, dist[i]));
                    }
                }

            }
            System.out.println();
            for (int i = 1; i <= nV; i++) {
                System.out.print(dist[i]);
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            PriorityQueue<Element> q = new <Element>PriorityQueue();

            nV = scan.nextInt();
            nE = scan.nextInt();

            visit = new boolean[nV + 1];
            dist = new int[nV + 1];
            ad = new int[nV + 1][nV + 1];


            for (int i = 0; i <= nV; i++) {
                dist[i] = inf;
            }


            for (int i = 0; i < nE; i++) {
                int t1 = 0;
                int t2 = 0;
                int t3 = 0;

                t1 = scan.nextInt();
                t2 = scan.nextInt();
                t3 = scan.nextInt();

                ad[t1][t2] = t3;
            }

            ssp(1);


        }

    }
}
