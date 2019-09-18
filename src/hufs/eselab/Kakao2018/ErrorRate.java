package hufs.eselab.Kakao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ErrorRate {
    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] res = s.solution(N,stages);
        for(int i : res){
            System.out.println(i);
        }
    }
    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = {};
            List<StageError> li_stage_error  = new ArrayList<>();
            for(int i = 1; i<=N ; i++){

                float errorRate= getErrorRate(i,stages);
                StageError se = new StageError(i,errorRate);
                li_stage_error.add(se);
            }

            //정렬
            Collections.sort(li_stage_error);
            answer = new int[N];
            for(int i = 0 ;i<N ; i++){
                answer[i] = li_stage_error.get(i).getStage();
            }
            return answer;
        }
        private float getErrorRate(int stage, int[] stages){
            float ret = 0;
            float not_done_player=0;
            float done_player=0;
            for(int st : stages){
                if(st == stage) not_done_player++;
                if(st >=stage) done_player++;
            }
            if(done_player ==0 ) return 0;
            ret = not_done_player/done_player;
            System.out.println(ret);
            return  ret;

        }

        class StageError implements Comparable<StageError>{
            private int stage;
            private float error;
            public StageError(int stage, float error) {
                this.stage = stage;
                this.error = error;
            }

            public int getStage() {
                return stage;
            }

            public float getError() {
                return error;
            }

            @Override
            public int compareTo(StageError target) {
                if(this.getError() < target.getError()) return 1;
                else if(this.getError()> target.getError()) return -1;
                else{//에러율 같을때
                    if(this.getStage() > target.getStage()) return 1;
                    else if(this.getStage() < target.getStage()) return -1;
                    return 0;
                }

            }
        }

    }


}
