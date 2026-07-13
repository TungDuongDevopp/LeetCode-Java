
import java.util.*;

class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (checkCapacity(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    private boolean checkCapacity(int[] weights, int days, int capacity) {
        int totalDay = 1;
        int remain = capacity;

        for (int weight : weights) {
            if (remain < weight) {
                totalDay++;
                remain = capacity;
            }
            remain -= weight;
        }

        return totalDay <= days;
    }
}
