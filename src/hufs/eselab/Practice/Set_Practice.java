package hufs.eselab.Practice;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 중복을 허용하지 x
 * 기본 연산자 : add, clear, contains, isEmpty, remove, size
 * HashSet
 * TreeSet
 * LinkedHashSet
 */
public class Set_Practice {
    public static void main(String[] args) {
        /**
         * HashSet : 삽입/삭제/제거 연산의 시간 복잡도 O(1)
         * 순서가 보장되지x
         */
        Set<Integer> hash_set =new HashSet<>();
        for (int i=10; i>=1; i--) {
            hash_set.add(i);
        }
        for (int x : hash_set) {
            System.out.print(x + " "); // 순서대로 출력이 보장되지 않는다.
        }


        System.out.println();
        /**
         * TreeSet
         * 삽입/삭제/제거 연산의 시간 복잡도가 O(lgN)
         * 순서가 보장 - %% 넣는 순서가 아닌 Comparable에 따라 보장됨 %%
         */
        Set<Integer> tree_set =new TreeSet<>();
        for (int i=10; i>=1; i--) {
            tree_set.add(i);
        }
        for (int x : tree_set) {
            System.out.print(x + " ");
        }
        System.out.println();

        /**
         * LinkedHashSet
         * 삽입/삭제/제거 연산의 시간 복잡도가 O(1)
         * 추가하는 순서대로
         */
        Set<Integer> linked_hash_set =new LinkedHashSet<>();
        for (int i=10; i>=1; i--) {
            linked_hash_set.add(i);
        }
        for (int x : linked_hash_set) {
            System.out.print(x + " ");
        }
        System.out.println();

    }
}
