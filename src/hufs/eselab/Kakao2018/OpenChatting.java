package hufs.eselab.Kakao2018;

import java.util.*;

public class OpenChatting {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] res = s.solution(record);
        for(String st : res){
            System.out.println(st);
        }
        System.out.println();
    }

    static class Solution {

        public String[] solution(String[] record) {
            String[] answer = {};
            List<UserData> li_ud = new ArrayList<>();
            for(String re : record){
                String state = re.split(" ")[0];
                String uid = re.split(" ")[1];
                String name = "";
                if(re.split(" ").length == 3) {
                    name = re.split(" ")[2];
                }
                UserData ud = new UserData(state,uid,name);
                li_ud.add(ud);
            }
            Map<String,String> uid_name = new HashMap<>();
            //최종 닉네임 찾기
            for(UserData ud : li_ud){
                if(ud.state.equals("Enter") || ud.state.equals("Change")) uid_name.put(ud.uid,ud.name);
            }

            List<String> res = new ArrayList<>();
            for(UserData ud : li_ud){
                String state = "";
                if(ud.state.equals("Enter")) state = "님이 들어왔습니다.";
                else if(ud.state.equals("Leave")) state = "님이 나갔습니다.";
                else continue;
                res.add(""+uid_name.get(ud.uid)+state);
            }
            answer = new String[res.size()];
            for(int i= 0 ;i<res.size() ;i++){
                answer[i]= res.get(i);
            }
            return answer;
        }

        class UserData{
            public String state;
            public String uid;
            public String name;

            public UserData(String state, String uid, String name) {
                this.state = state;
                this.uid = uid;
                this.name = name;
            }

            public String getState() {
                return state;
            }

        }


    }

}
