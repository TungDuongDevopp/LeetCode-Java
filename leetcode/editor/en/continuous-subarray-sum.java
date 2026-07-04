import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        //Khởi tạo bien prefix
        int prefix = 0;

        // Khơi tạo HashMap lưu reminder, index
        Map <Integer,Integer> map = new HashMap<>(Math.min(nums.length,k));

        // Đặt giá trị ban đầu là -1
        map.put(0,-1);
        for(int i = 0;i<nums.length ; i++){
            // Cập nhật prefix
            prefix+=nums[i];
            // Tính module
            int remainer = prefix % k;
            // Kiểm tra sự tồn tại remainer
            if(map.containsKey(remainer)){
                if(i - map.get(remainer)>=2) return true;
            }
            // Chỉ thêm nếu map chưa có để tính độ dài xa nhất
            else{
                map.put(remainer,i);
            }

        }
        // Nếu không có hai reminder trùng nhau không có sub array
        return false;
    }
}
