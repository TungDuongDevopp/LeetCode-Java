
import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length()!= t.length()) return false;
        Map <Character,Integer> map= new HashMap<>();

        for(char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);

        }

        for(char c : t.toCharArray()) {
            if(map.getOrDefault(c, 0) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;

    }
}

