
import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        double low = (double) arr[0]/arr[arr.length-1];
        double high = 1.0;

        // Mảng này dùng để "hứng" cặp số [tử số, mẫu số] lớn nhất từ hàm helper
        int[] result = new int[2];

        // Chặt nhị phân số thực 60 lần là đủ đạt độ chính xác tuyệt đối
        for (int iter = 0; iter < 60; iter++) {
            double mid = low + (high - low) / 2;

            // Đếm số lượng phân số <= mid, đồng thời cập nhật cặp số sát biên nhất vào 'result'
            int totalPairs = countLessOrEqual(arr, mid, result);

            if (totalPairs == k) {
                return result; // Tìm thấy đúng k phân số, trả về kết quả luôn
            } else if (totalPairs > k) {
                high = mid; // Nhiều cặp quá, giảm giới hạn trên xuống
            } else {
                low = mid;  // Ít cặp quá, tăng giới hạn dưới lên
            }
        }

        return result;
    }

    // Hàm Helper: Chuyên trách Two Pointers để đếm và tìm cặp phân số sát biên
    private int countLessOrEqual(int[] arr, double mid, int[] result) {
        int n = arr.length;
        int total = 0;
        int j = 1;

        double maxFractionInVound = 0.0;

        // Duyệt con trỏ i làm tử số
        for (int i = 0; i < n - 1; i++) {
            // Dịch con trỏ j (mẫu số) sang phải chừng nào phân số còn > mid
            while (j < n && arr[i] > mid * arr[j]) {
                j++;
            }

            // Toàn bộ các mẫu số từ vị trí j đến n-1 đều tạo ra phân số <= mid
            total += (n - j);

            // Nếu tìm thấy một phân số hợp lệ (<= mid), check xem nó có phải lớn nhất không
            if (j < n) {
                double currentFraction = (double) arr[i] / arr[j];
                if (currentFraction > maxFractionInVound) {
                    maxFractionInVound = currentFraction;
                    result[0] = arr[i]; // Ghi đè tử số tốt nhất vào mảng kết quả
                    result[1] = arr[j]; // Ghi đè mẫu số tốt nhất vào mảng kết quả
                }
            }
        }

        return total; // Trả về tổng số lượng phân số đếm được
    }
}



