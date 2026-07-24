
import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;

       while (left<right){
           int mid = left + (right - left)/2;
           if(checkDuplicate(mid,nums)){
               right = mid;
           }
           else{
               left = mid+1;
           }
       }
       return left;


    }
    private  boolean checkDuplicate(int mid, int[] nums){
        int count = 0;
        for(int num: nums){
            if(num<=mid){
                count++;
            }
        }
        return count>mid;
    }


}

