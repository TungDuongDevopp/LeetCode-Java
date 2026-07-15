import  java.util.*;
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;

        // Tìm thời gian ít nhất của tất cả xe
        long minTime = Long.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        // Thời gian tối đa có thể cần để chở hết người
        long right = minTime * totalTrips;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isValid(mid, time, totalTrips)) {
                right = mid - 1; // Thời gian đủ, giảm thời gian
            } else {
                left = mid + 1; // Thời gian quá ngắn, phải tăng lên
            }
        }
        return left;
    }

    private boolean isValid(long hour, int[] time, int totalTrips) {
        long actualTrips = 0;
        for (int t : time) {
            actualTrips += hour/t;
            if (actualTrips >= totalTrips) {
                return true; // Nếu thỏa mán điều kiện thoát sớm
            }
        }
        return actualTrips >= totalTrips;
    }
}
