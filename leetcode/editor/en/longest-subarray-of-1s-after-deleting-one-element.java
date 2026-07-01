
import java.util.*;

class Solution {
    public int longestSubarray(int[] nums) {

        // Khai báo biến độ dài
        int maxLen = 0;

        // Khai báo biến con trỏ
        int left = 0;

        //Khai báo biến đếm
        int countZero = 0;

        for(int right = 0; right<nums.length;right++){

            if(nums[right]==0) countZero++;

            // Vi phạm khi count>1
            while(countZero>1){
                if(nums[left] == 0) countZero--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left);
        }
        return maxLen;
    }
}

