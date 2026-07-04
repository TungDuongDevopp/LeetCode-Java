
import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {

       // Khai báo biến target
        int target = 0;

       for(int num : nums){
           target = (target+num) % p;
       }
        // Nếu tổng cả mảng chia hết thì không phải loại bỏ mảng nào
        if(target == 0) return  0;

        // Khai báo biến prefixmod
        int prefixMod = 0;
         // Khai báo biến length
        int minLen = nums.length;

        // Khai báo hashmap lưu prefixMod, index
        Map <Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i = 0;i<nums.length;i++){
            prefixMod = (prefixMod+nums[i]) % p;
            int needPrefix =  (prefixMod - target + p) % p;
            if(map.containsKey(needPrefix)) {
                minLen = Math.min(minLen,i - map.get(needPrefix));
            }
             map.put(prefixMod,i);
            }
        return  minLen == nums.length  ? -1 : minLen;
        }

}

