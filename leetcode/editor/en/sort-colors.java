
import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        //Đặt con trỏ
        int low = 0;
        int mid = 0;
        int hight = nums.length-1;
        int temp;
        while(mid<=hight){
                if(nums[mid]==0){
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    low++;
                    mid++;
                }
                else if(nums[mid]==2){
                    temp = nums[mid];
                    nums[mid] = nums[hight];
                    nums[hight] = temp;
                    hight--;
                }
                // Nếu nums[mid] == 1
             else {
                 mid++;
                }
        }
    }
}

