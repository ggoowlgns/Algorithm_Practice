package hufs.eselab.KaKao2017;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShuttleBus {
    public static void main(String[] args){
        Solution s = new Solution();
        int n = 1;
        int t= 1;
        int m = 1;
//        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
//        String[] timetable = {"09:10", "09:09", "08:00"};
        String[] timetable = {"23:59"};
        System.out.println(s.solution(n,t,m,timetable));
    }
    static class Solution {
        List<Date> justBefore_bus_crews = new ArrayList<>();
        SimpleDateFormat simpleDateFormat;
        public String solution(int n, int t, int m, String[] timetable) {
            String answer = "";
            try {
                simpleDateFormat= new SimpleDateFormat("HH:mm");

                List<Date> crew_time_table = new ArrayList<>();
                for(String temp : timetable) {
                    crew_time_table.add(simpleDateFormat.parse(temp));
                }
                Collections.sort(crew_time_table);
                List<Date> busTimeTable = makeBusTimeTable(n,t,simpleDateFormat);

                for(Date busTime : busTimeTable){

                    //빠지고 나머지 크루만 탄다
                    crew_time_table = pickUpCrew(crew_time_table, busTime,m);

                    //아직 버스 뒤에 있는데 앞에 다탐
                    if(crew_time_table.size() == 0 && (busTimeTable.indexOf(busTime) != busTimeTable.size()-1)) answer =simpleDateFormat.format(busTimeTable.get(busTimeTable.size()-1)) ;//맨 마지막 버스
                    else if(crew_time_table.size() == 0 && (busTimeTable.indexOf(busTime) == busTimeTable.size()-1) && justBefore_bus_crews.size()==m){
                        //마지막 버스 태웠더니 딱 다탐
                        Date last_crew_time = findLastCrewInBus(justBefore_bus_crews);
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(last_crew_time);
                        cal.add(Calendar.MINUTE, -1);
                        last_crew_time = cal.getTime();
                        answer = simpleDateFormat.format(last_crew_time);

                    }else if(crew_time_table.size() == 0 && (busTimeTable.indexOf(busTime) == busTimeTable.size()-1) && justBefore_bus_crews.size()!=m){
                        //마지막 버스 태웠더니 좀 남음
                        answer =simpleDateFormat.format(busTimeTable.get(busTimeTable.size()-1)) ;//맨 마지막 버스
                    }
                    else if((busTimeTable.indexOf(busTime) == busTimeTable.size()-1) && crew_time_table.size()!=0){
                        //마지막 버스 태웠는데 사람 남음
                        Date last_crew_time = findLastCrewInBus(justBefore_bus_crews);
                        Date init_time = simpleDateFormat.parse("00:00");
                        //마지막거에 들어있는게 없다.
                        if (last_crew_time.compareTo(init_time) == 0) {
                            answer = simpleDateFormat.format(busTimeTable.get(busTimeTable.size() - 1));
                        }
                        else{Calendar cal = Calendar.getInstance();
                        cal.setTime(last_crew_time);
                        cal.add(Calendar.MINUTE, -1);
                        last_crew_time = cal.getTime();
                        answer = simpleDateFormat.format(last_crew_time);}
                    }
                }


            } catch (ParseException e) {
                e.printStackTrace();
            }

            return answer;
        }
        private Date findLastCrewInBus(List<Date> justBefore_bus_crews) throws ParseException {
            Date ret = simpleDateFormat.parse("00:00");
            //제일 늦게 탄놈 구함
            for(Date temp :justBefore_bus_crews){
                if(temp.after(ret)) ret = temp;
            }

            return ret;
        }

        private List<Date> makeBusTimeTable(int n,int t, SimpleDateFormat simpleDateFormat) throws ParseException {
            List<Date> busTimeTable = new ArrayList<>();
            Date busTime = simpleDateFormat.parse("09:00");
            for(int i=0; i<n;i++){
                busTimeTable.add(busTime);
                Calendar cal = Calendar.getInstance();
                cal.setTime(busTime); // 10분 더하기
                cal.add(Calendar.MINUTE, t);
                busTime = cal.getTime();
            }
            for(Date temp : busTimeTable){
//                System.out.println(temp.toString());
            }

            return busTimeTable;
        }

        private List<Date> pickUpCrew(List<Date> crew_time_table, Date busTime,int m){
            List<Date> ret = new ArrayList<>();
            justBefore_bus_crews = new ArrayList<>();
            //그대로 복제
            for(Date crew_time : crew_time_table){
                ret.add(crew_time);
            }
            int count = 0;
            for(Date crew_time : crew_time_table){
                if(!crew_time.after(busTime) && count<m) {
                    ret.remove(crew_time); count++;
                    justBefore_bus_crews.add(crew_time);
                }
            }

            return ret;
        }
    }
}
