import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        if (k < 0) return 0;
        //Khai báo biến đếm tần số
        Map <Integer,Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            // Thêm phần tử bên phải vào cửa sổ
            map.merge(nums[right],1,Integer::sum);

            // Thu nhỏ cửa sổ từ bên trái nếu số lượng phần tử khác nhau vượt quá k
            while (map.size() > k && left<= right ) {
               map.merge(nums[left],-1,Integer::sum);
               if(map.get(nums[left])==0) map.remove(nums[left]);
               left++;
            }
            // Cộng dồn số lượng mảng con hợp lệ kết thúc tại 'right'
            ans += right - left + 1;
        }

        return ans;
    }
}
