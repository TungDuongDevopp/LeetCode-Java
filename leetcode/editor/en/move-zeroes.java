import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0; // Khai báo fast bên ngoài vòng lặp
        int temp;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++; // Tăng fast lên 1 sau mỗi lượt kiểm tra
        }
    }
}
