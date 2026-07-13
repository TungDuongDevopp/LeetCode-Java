
import java.util.*;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //Khai báo biến left,right
        int left = 1;
        int right =1;
        for(int num : nums){
            right = Math.max(right,num);
        }
        while(left<=right){
            int mid = left + (right-left)/2;
            //Nếu thỏa mãn mid giảm giá trị mid
            if(checkDivisor(nums,mid,threshold)){
                right = mid-1;
            }
            //Nếu k thỏa mãn mid, tăng giá trị mid
            else {
                left = mid+1;
            }
        }
        return left;
    }
    private boolean checkDivisor(int[] nums,int divisor, int threshold){
        long sum = 0;
        for(int num : nums){
            sum += (num + divisor - 1)/divisor;
            if(sum>threshold) return false;
        }
        return sum<=threshold;
    }
}

