
import java.util.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums[nums.length-1] - nums[0];

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (checkPair(nums, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;


    }
    private boolean checkPair(int[] nums, int k, int mid) {
        int total = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {


            while (nums[right] - nums[left] > mid) {
                left++;
            }
            total += right - left;
        }

        return total >= k;
    }



}

