package hufs.eselab.KaKao2017;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChusuckTraffic {
    public static void main(String[] args){
//        String[] lines = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        String[] lines = {"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        Solution s = new Solution();
        System.out.println(s.solution(lines));
    }
    static class Solution {
        public int solution(String[] lines) {
            List<double[]> li_logs = new ArrayList<>();
            for(String s : lines){
                String[] s_split = s.split(" ");
//                s_split[0] = String.join("",s_split[0].split("-")).substring(5);
                s_split[1] = String.join("",s_split[1].split(":"));
//                String time = String.join("", Arrays.copyOfRange(s_split,0,2));
                String time = s_split[1];
                Double d_time = (double)Double.parseDouble(time);
                Double range = (double)Double.parseDouble(s_split[2].substring(0,s_split[2].length()-1));

                double[] res = {Math.round((time_transform(d_time-range)+0.001)*1000)/1000.0, d_time};//시작,끝 - Math.round 반올림
                li_logs.add(res);
            }
            int answer = 0;
            for(double[] log : li_logs) {
                int temp = Math.max(how_many_traffics(li_logs,log[1],log[1]+1), how_many_traffics(li_logs,log[0]-1,log[0]));
                answer = Math.max(answer,temp);
            }


            return answer;
        }
        private int how_many_traffics(List<double[]> li_logs, double str, double end){
            int ret = 0;
            for(double[] log : li_logs){

                if(log[1]>=str && log[0]<=end) ret++;    //<= ? <
            }
            return ret;
        }
        private double time_transform(double time){
            //hhmmss.sss
            int int_time = (int)time;
            double sosu_time = time-int_time;

            int hour = int_time/10000;
            int min = (int_time%10000)/100;
            int sec = int_time%100;

            if(min>=60) min = min-40;
            if(sec>=60) sec = sec-40;
            int_time = Integer.valueOf(String.format("%02d",hour)+""+String.format("%02d",min)+""+String.format("%02d",sec));

            return int_time+sosu_time;
        }
    }
}
