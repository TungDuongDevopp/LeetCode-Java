
import java.util.*;

class Solution {
    public int splitArray(int[] nums, int k) {
     int min = 0;
     int max = 0;
     for(int num : nums){
         min = Math.max(num,min);
         max+= num;
     }
     while (min<=max){
         int mid  = min + (max - min)/2;
         if(checkSum(nums,k,mid)){
             max = mid -1;
         }
         else {
             min = mid + 1;
         }

     }
     return min;

    }
    private boolean checkSum(int[]nums,int k, int maxSum){
        int sum = 0;
        int countSubarray = 1;
        for(int num : nums){
            if(num+sum> maxSum){
                countSubarray++;
                sum = num;
            }
            else{
                sum+=num;
            }

        }
        return countSubarray <=k;
    }
}

