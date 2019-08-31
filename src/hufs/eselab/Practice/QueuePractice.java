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


}
