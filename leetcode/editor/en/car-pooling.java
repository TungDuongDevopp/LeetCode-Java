
import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Tạo mảng lưu đáp án
        int [] ans = new int[1001];

        for(int nums[] : trips){
            int passengers = nums[0];
            int from  = nums[1];
            int to = nums[2];
            if(passengers>capacity) return false;
            // Cộng tại thời điểm bắt đầu
            ans[from] += passengers;
            //Trừ tại thời điểm kết thúc
            ans[to]-=passengers;

        }
        // Cộng dồn mảng prefix
        if (ans[0] > capacity) return false;
        for(int i = 1; i<ans.length;i++){
             ans[i] += ans[i-1];
             if(ans[i]>capacity) return false;
        }
        return true;
    }
}

