
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String,List<String>> map = new HashMap<>();
        String key;
        for (String s : strs){
            key = sortString(s);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public String sortString(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
