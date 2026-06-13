import java.util.*;

class Solution {
    public int trap(int[] height) {
        // Nếu mảng ít hơn 3 cột thì không thể giữ được nước
        if (height == null || height.length < 3) return 0;

        int left = 0;
        int right = height.length - 1;

        // Lưu độ cao lớn nhất tại thời điểm duyệt của 2 phía
        int left_max = 0;
        int right_max = 0;
        int max_units = 0;

        while (left < right) {
            // Phía bên trái thấp hơn phía bên phải
            if (height[left] < height[right]) {
                // Nếu cột hiện tại cao hơn left_max cũ -> cập nhật đỉnh mới
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    // Nếu thấp hơn left_max -> chắc chắn hứng được nước
                    max_units += left_max - height[left];
                }
                left++; // Dịch con trỏ trái vào trong
            }
            // Phía bên phải thấp hơn hoặc bằng phía bên trái
            else {
                // Nếu cột hiện tại cao hơn right_max cũ -> cập nhật đỉnh mới
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    // Nếu thấp hơn right_max -> chắc chắn hứng được nước
                    max_units += right_max - height[right];
                }
                right--; // Dịch con trỏ phải vào trong
            }
        }

        return max_units;
    }
}
