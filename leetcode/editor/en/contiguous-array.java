import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        // Khởi tạo biến đo độ dài lớn nhất
        int maxLen = 0;

        // Khai báo biến prefix
        int prefix  = 0;

        //Khai báo HashMap lưu prefix,index
        Map <Integer,Integer> map = new HashMap<>();

        // Đưa phần tử ảo 0 -> -1 vào map
        map.put(0,-1);

        for(int i = 0; i<nums.length;i++){
            //coi 0 = -1, 1=1
            prefix += (nums[i] == 0) ? -1 : 1;

            //Nếu có prefix trùng, tính length thông qua value
            if(map.containsKey(prefix)){
                maxLen = Math.max(maxLen,i-map.get(prefix));
            }
            // Chỉ thê prefix khi mới xuất hiện lần đầu để tính max len
            else{
                map.put(prefix,i);
            }

        }

        // return kết quả trả về
        return maxLen;
    }
}
