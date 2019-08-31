package hufs.eselab.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListPractice {
    List li;
    public ListPractice() {
        li = new ArrayList<>();
    }
    public void list_functions(){
        li.add(1);
        li.add(2);
        li.add(6);
        li.add(10);
        li.add(3);
        li.add(2);

        //일정한 값으로만 가능
//        li.add("1");

        //정렬
        Collections.sort(li);

        //거꾸로 정렬
        Collections.sort(li, new AscendingInteger());
        for(Object i : li) {
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        ListPractice lp = new ListPractice();
        lp.list_functions();
    }

    //자동 정렬 - ctrl + alt + l
    class AscendingInteger implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }

}
