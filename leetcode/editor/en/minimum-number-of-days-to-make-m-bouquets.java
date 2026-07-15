
import java.util.*;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Nếu tổng số hoa cần > số ngày bông nở thì vô nghiệm
        long totalNeeded = (long) m * k;
        if (totalNeeded > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day); // Tìm số hoa nở ít nhất trong ngày
            high = Math.max(high, day); // Tìm số hoa nở nhiều nhất trong ngày
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid; // Đủ ngày, cần giảm ngày xuống
                high = mid - 1;
            } else {
                low = mid + 1; // Thiếu ngày, cần tăng ngày lên
            }
        }

        return ans;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0; // Khởi tạo biến đếm bó hoa
        int consecutiveFlowers = 0; // Khởi tạo chuỗi nở hoa

        for (int day : bloomDay) {
            if (day <= days) {
                consecutiveFlowers++; // Nếu ngày nở hoa
                //Nếu gom đủ số hoa thì tạo được thành 1 bó
                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0; // Reset biến thực hiện đếm lại
                }
            } else {
                consecutiveFlowers = 0; // Hoa không nở, thực hiện đếm lại
            }
        }

        return bouquets >= m;
    }
}

