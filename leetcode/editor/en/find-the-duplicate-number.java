
import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        // Đặt con trỏ
       int slow = nums[0];
       int fast = nums[0];
        do {
            slow = nums[slow];          // Rùa đi 1 bước
            fast = nums[nums[fast]];    // Thỏ đi 2 bước
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];          // Cả hai cùng đi 1 bước
            fast = nums[fast];
        }
        return slow;
    }
}

