
import java.util.*;

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 2;
        for(int num : nums){
            right  =  Math.max(right,num);
        }

        while(left<= right){
            int mid = left + (right - left)/2;
            if(checkBall(nums,maxOperations,mid)){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean checkBall(int [] nums, int maxOperations, int ball){
        int operations = 0;
        for(int num : nums){
            operations += (num - 1) / ball;
            if (operations > maxOperations) {
                return false;
            }
          }
        return true;
    }
}

