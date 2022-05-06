package May2022.day01;

import java.util.*;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/6 15:47
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for(String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array) ;
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());

    }

}
