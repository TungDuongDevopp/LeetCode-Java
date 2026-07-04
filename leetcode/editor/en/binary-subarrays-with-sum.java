
import java.util.*;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Khai báo biến đếm
        int count  = 0;

        // Khai báo biến prefix
        int prefix = 0;

        //Khai báo hashmap lưu prefix-> frequency
        Map <Integer,Integer> map = new HashMap<>();
        // Đặt phần tử ảo 0-> 1;
        map.put(0,1);
        for (int num : nums) {
            prefix += num;

            count += map.getOrDefault(prefix - goal, 0);

            map.merge(prefix,1,Integer::sum);
        }

        // Trả kết quả
        return count;
    }

}


