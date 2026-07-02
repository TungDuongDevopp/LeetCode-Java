import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map lưu: Key = Số dư (prefix % k), Value = Chỉ số i đầu tiên xuất hiện số dư đó
        HashMap<Integer, Integer> map = new HashMap<>();

        // Khởi tạo: Số dư 0 xuất hiện ở vị trí "ảo" là -1
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Lấy số dư của tổng tích lũy với k
            int remainder = prefixSum % k;

            // Nếu đã từng thấy số dư này trước đó rồi
            if (map.containsKey(remainder)) {
                // Kiểm tra khoảng cách giữa vị trí hiện tại và vị trí cũ xem có >= 2 không
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Chỉ lưu vị trí ĐẦU TIÊN xuất hiện số dư này để giữ khoảng cách xa nhất có thể
                map.put(remainder, i);
            }
        }

        return false;
    }
}
