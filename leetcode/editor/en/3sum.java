
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if(nums[0]>0|| nums[nums.length-1]<0) return result;
        for(int i = 0; i< nums.length;i++){
            // Kiểm tra phần  tử i đã lớn hơn 0 chưa nếu lớn hơn thì break;
            if(nums[i]> 0) break;

            //Kiếm tra nếu phần tử thứ i(i>0) trùng với phần tử i-1 thì bỏ qua tránh trùng bộ
            if(i>0 && nums[i] == nums[i-1]) continue;

            // Đặt con trỏ left từ vị trí i + 1, right tại vị trí cuối mảng
            int left = i + 1;
            int right = nums.length-1;

            // Dùng vòng lặp while để duyệt và dừng khi left và right gặp nhau
            while(left<right){
                // Tính kết quả left+ right + current
                int sum = nums[left] + nums[i] + nums[right];

                // Kiểm tra xem kết quả đã  == 0 nếu thỏa mãn add vào result;
                if(sum == 0){
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // Dịch tiếp left và right nếu phần tử thứ i trùng i-1 thì bỏ qua tránh trùng bộ
                    while(left <right && nums[left]==nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }

                // Nếu sum < 0 dịch left lên 1
                else if(sum<0){
                    left ++;
                }
                // Ngược lại nếu sum > 0 dịch right xuống 1
                else{
                    right --;
                }
            }
        }
        // trả kết quả
        return result;
    }
}

