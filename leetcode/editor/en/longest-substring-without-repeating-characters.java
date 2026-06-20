import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int maxLength = 0;
        int left = 0;

        // 1. Dùng vòng FOR để liên tục mở rộng con trỏ bên phải (right)
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 2. Nếu ký tự mới ĐÃ TỒN TẠI trong set (vi phạm điều kiện)
            // Dùng WHILE để thu hẹp cửa sổ từ bên trái cho đến khi hết trùng
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left)); // Xóa ký tự ở biên trái ra khỏi set
                left++; // Dịch con trỏ trái sang phải
            }

            // 3. Thêm ký tự hiện tại vào set vì cửa sổ bây giờ đã hợp lệ
            set.add(currentChar);

            // 4. Cập nhật chiều dài lớn nhất (công thức tính độ dài: right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
