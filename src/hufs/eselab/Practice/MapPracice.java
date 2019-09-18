package hufs.eselab.Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HashMap
 * TreeMap - RedBlack Tree를 이용
 * LinkedHashMap
 * 주요 Method :
 *
 * void clear() : Map을 초기화
 * boolean containsKey(Object key) : 어떠한 Key가 들어있는지 확인
 * boolean containsValue(Object value) :  어떠한 Value를 가지고 있는지 확인
 * Set<Map.Entry<K,V>> entrySet() : Key, Value 쌍을 이용한 Set을 생성
 * V get(Object key) :  Key에 해당하는 Value Return
 * boolean isEmpty() : 비어있는지 확인
 * Set< K> key keySet() : Key를 이용해 Set을 만들어줌
 * V put(K key, V value) : Key, Value 쌍을 넣을 수 있음
 * boolean remove(Object o) : 해당하는 Key를 Remove
 * int size() : Size Return
 */
public class MapPracice {
    public static void main(String[] args) {
        List<String> li = new ArrayList<>();
        li.add("박지훈");
        li.add("나윤호");
        li.add("박지훈");
        li.add("황재동");
        li.add("이태희");
        li.add("문명기");
        li.add("박지훈");
        li.add("나윤호");
        li.add("이태희");
        li.add("박지훈");
        li.add("나윤호");
        li.add("문명기");
        Map<String,Integer> hash_map = new HashMap<>();
        for(String name : li){
            if(hash_map.containsKey(name)){
                int num = hash_map.get(name);
                hash_map.put(name,++num);
            }
            else hash_map.put(name,1);
        }

        //그냥 hash_map에서는 못뺌
        for(Map.Entry<String, Integer> entry : hash_map.entrySet()){
            System.out.println("KEY : "+entry.getKey()+", VALUE : "+entry.getValue());
        }
    }
}
