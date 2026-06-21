
import java.util.*;

class Solution {
    public int longestOnes(int[] nums, int k) {

        // Khai báo con trỏ
        int left = 0;

        // Khai báo maxLength
        int maxLength = 0;

        // Khai báo biến đếm zero
        int countZero = 0;
        for(int right = 0; right<nums.length;right++){
            //Thực hiện đếm số 0
            if(nums[right] == 0) countZero++;
            //Vi phạm điều kiện khi gặp nhiều zero hơn k
            while(countZero>k){
                if(nums[left]== 0) countZero--;
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }

        // Trả về kết quả
        return maxLength;
    }
}

