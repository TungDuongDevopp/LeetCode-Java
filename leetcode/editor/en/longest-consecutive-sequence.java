
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
         Set<Integer> set = new HashSet<>();
         int longest = 1;
         for (int num : nums){
             set.add(num);
         }

         for(int num : set){
                if(!set.contains(num - 1)){
                    int current =  num;
                    int length = 1;
                    while(set.contains(current + 1)){
                        current++;
                        length ++;
                    }
                    longest = Math.max(longest,length);
                }

         }
        return longest;
    }

}

