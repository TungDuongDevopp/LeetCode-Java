
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // prefix = 0 xuất hiện 1 lần

        int prefix = 0;
        int ans = 0;

        for (int num : nums) {
            prefix += num;

            ans += map.getOrDefault(prefix - k, 0);

            map.merge(prefix,1,Integer::sum);
        }
        return ans;
    }
}