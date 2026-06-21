import  java.util.*;
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        long sum = 0;

        // Tính tổng cửa sổ đầu tiên
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        long maxSum = sum;

        // Trượt cửa sổ
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];       // thêm phần tử mới
            sum -= nums[i - k];   // bỏ phần tử cũ

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}