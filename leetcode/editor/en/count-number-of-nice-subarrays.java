
import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
    private int atMostK(int[] nums,int k){

        if(k < 0) return 0;

        // Khai báo biến đếm
        int count  = 0;
        int countOdd = 0;

        //Khai báo con trỏ
        int left = 0;

        for(int right = 0;right<nums.length;right++){

            //Kiểm tra right là chẵn hay lẻ
            if(nums[right] % 2 != 0) countOdd++;

            while (countOdd>k){
                if(nums[left]%2 != 0) countOdd--;
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}

