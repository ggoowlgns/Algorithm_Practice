package hufs.eselab.ProgrammersProblems;

import java.util.*;

public class PassingBridge {
    public static void main(String[] args) {
        int bridge_length=2;
        int weight=10;
        int[] truck_weights={7,4,5,6};
        Solution s = new Solution();
        System.out.println(s.solution(bridge_length,weight,truck_weights));
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Truck> left_trucks = new LinkedList<>();
            for(int truck_weight : truck_weights){
                left_trucks.offer(new Truck(truck_weight, 0));
            }

            List<Truck> on_trucks = new ArrayList<>();
            List<Truck> finish_trucks = new ArrayList<>();
            int time = 0;
            while(finish_trucks.size()!=truck_weights.length) {
                Truck next_truck = left_trucks.peek();

                List<Truck> remove_trucks = new ArrayList<>();
                //on truck 애들 하나씩 이동
                for(Truck truck : on_trucks){
                    if((truck.getMoved_len()+1) >bridge_length ) remove_trucks.add(truck);
                    else {
                        truck.setMoved_len(truck.getMoved_len() + 1);
                    }
                }

                for(Truck rem_truck : remove_trucks) {on_trucks.remove(rem_truck);finish_trucks.add(rem_truck);}

                if(next_truck != null) {
                    //다음거 들어와도 괜찮으면 들어와
                    if ((get_weight_on_bridge(on_trucks) + next_truck.getWeight()) <= weight) {
                        next_truck = left_trucks.poll();
                        next_truck.setMoved_len(1);
                        on_trucks.add(next_truck);
                    }
                }
                time++;
            }

            answer = time;
            return answer;
        }

        //다리 위 weight 측정
        public int get_weight_on_bridge(List<Truck> on_trucks){
            int ret = 0;
            for(Truck t : on_trucks){
                ret += t.getWeight();
            }
            return ret;
        }

        public class Truck{
            private int weight;
            private int moved_len;

            public Truck(int weight, int moved_len) {
                this.weight = weight;
                this.moved_len = moved_len;
            }

            public int getWeight() {
                return weight;
            }

            public int getMoved_len() {
                return moved_len;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public void setMoved_len(int moved_len) {
                this.moved_len = moved_len;
            }
        }
    }


}
