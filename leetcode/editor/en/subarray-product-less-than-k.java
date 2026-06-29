
import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k == 0) return 0;

        //Khai báo con trỏ
        int left = 0;

        // Khai báo biến tính tích
        double multi = 1;

        // Khai báo biến đếm
        int count = 0;

        for(int right =0; right<nums.length;right++){

            // nhân right vào mul
            multi*=nums[right];

            while(multi>=k && left<=right){
                multi/=nums[left];
                left++;
            }
            count+=right-left+1;
        }

        return count;
    }
}
