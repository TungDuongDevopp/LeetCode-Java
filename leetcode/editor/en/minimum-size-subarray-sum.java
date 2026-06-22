import java.util.*;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        // Khởi tạo minLength bằng giá trị lớn nhất
        int minLength = Integer.MAX_VALUE;


        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Mở rộng cửa sổ sang phải

            // Thu hẹp cửa sổ từ bên trái tối đa có thể khi tổng vẫn thỏa mãn
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        // Nếu minLength không thay đổi, nghĩa là không tìm thấy mảng con nào
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
