
import java.util.*;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal-1);
    }
    private int atMostK(int [] nums,int goal) {

        if (goal < 0) return 0;
        //Khai báo con trỏ
        int left = 0;

        //Khai báo biến đếm s subarray
        int count = 0;

        //Khai báo biến tính tổng các phần tử
        int sum = 0;
        for(int right = 0;right<nums.length;right++){

            // Cộng phan tử thứ right
            sum+=nums[right];

            //Vi phạm khi sum>goal
            while(sum>goal){
                sum-=nums[left];
                left++;
            }

            // Cập nhật biến đếm
            count +=right-left+1;
        }
        return count;
    }
}


