package hufs.eselab.Practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePractice {
    //FIFO
    Queue q;
    PriorityQueue pq;
    public QueuePractice() {
        q = new LinkedList();
        pq = new PriorityQueue();
    }
    public void queue_functions(){
        q.offer("1");
        q.offer("2");
        q.offer("3");
        q.add("4");
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
    }


    public void priority_queue_functions(){
//        pq.offer("1");
//        pq.offer("5");
//        pq.offer("4143");
//        pq.offer("3");
//        pq.offer("2");
//        pq.offer("1");

        //섞으면 안된다.
        pq.offer(1);
        pq.offer(5);
        pq.offer(4143);
        pq.offer(3);
        pq.offer(2);
        pq.offer(1);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
    public static void main(String[] args){
        QueuePractice qp = new QueuePractice();
//        qp.queue_functions();
        qp.priority_queue_functions();
    }


    /**
     * Queue에 넣을 객체 - Node
     */
    class Node implements Comparable<Node>{
        private String UUID;
        private String parentUUID;
        private double G;
        private double H;

        public Node(String UUID, double G, double H) {
            this.UUID = UUID;
            this.parentUUID = null;
            this.G = G;
            this.H = H;
        }

        public String getUUID() {
            return UUID;
        }

        public String getParentUUID() {
            return parentUUID;
        }
        public double getF() { return G + H; }
        public double getG() {
            return G;
        }

        public double getH() {
            return H;
        }

        @Override
        public int compareTo(Node target) {
            if (this.getF() > target.getF()) {
                return 1;
            } else if (this.getF() < target.getF()) {
                return -1;
            }

            return 0;
        }
    }

}
