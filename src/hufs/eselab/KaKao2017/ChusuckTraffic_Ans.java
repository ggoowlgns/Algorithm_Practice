package hufs.eselab.KaKao2017;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChusuckTraffic_Ans {
    class TrafficNode
    {
        public long startTime = 0;
        public long endTime = 0;
    }

    class Solution {
        public int solution(String[] lines) {
            int answer = 0;
            int maximumTraffic = 0;
            ArrayList<TrafficNode> nodeList = new ArrayList<>();

            try
            {
                for(int i = 0; i < lines.length; i++)
                {
                    String[] splitString = lines[i].split(" ");
                    String strCurrentDate = splitString[0] + " " + splitString[1];
                    Date currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(strCurrentDate);
                    long endTime = currentDate.getTime();
                    long startTime = endTime - getMilisecond(splitString[2]) + 1;
                    TrafficNode temp = new TrafficNode();
                    temp.startTime = startTime;
                    temp.endTime = endTime;
                    nodeList.add(temp);
                }
            }
            catch(Exception e)
            {
            }

            for(int i = 0; i < nodeList.size(); i++)
            {
                int traffic = 0;
                long timeCheckStart = nodeList.get(i).startTime;
                long timeCheckEnd = nodeList.get(i).startTime + 999;
                for(int j = 0; j < nodeList.size(); j++)
                {
                    if(nodeList.get(j).startTime > timeCheckEnd || nodeList.get(j).endTime < timeCheckStart)
                    {
                        continue;
                    }
                    traffic++;
                }

                if(maximumTraffic < traffic)
                {
                    maximumTraffic = traffic;
                }
            }

            for(int i = 0; i < nodeList.size(); i++)
            {
                int traffic = 0;
                long timeCheckStart = nodeList.get(i).endTime;
                long timeCheckEnd = nodeList.get(i).endTime + 999;
                for(int j = 0; j < nodeList.size(); j++)
                {
                    if(nodeList.get(j).startTime > timeCheckEnd || nodeList.get(j).endTime < timeCheckStart)
                    {
                        continue;
                    }
                    traffic++;
                }

                if(maximumTraffic < traffic)
                {
                    maximumTraffic = traffic;
                }
            }
            answer = maximumTraffic;
            return answer;
        }

        public long getMilisecond(String temp)
        {
            return (long) (Float.valueOf(temp.substring(0,temp.length()-1)) * 1000);
        }
    }

}
