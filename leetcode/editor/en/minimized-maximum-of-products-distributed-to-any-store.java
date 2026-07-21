
import java.util.*;

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // n : store
        // m : product type  = quantities.length
        // q : quantites = quantities[i]
        //  1n -> 1m (0->q)
        //  x = Max(q1,q2,qn) sao cho sum (q1,q2,...qn) = sum(quantities[0],quantities[1],...quantities[length-1]);
        int left  = 1; // So sản phẩm tối thiểu mỗi cửa hàng nhận
        int right = 1;
        for(int quantity : quantities){
            right = Math.max(right,quantity);
        }
        while(left<=right){
            int mid = left + (right - left)/2;
            if(checkQuantity(n,quantities,mid)){
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean checkQuantity(int n,int[] quantities,int limit){
       // Khởi tạo tổng số quán phát hàng
        int stores = 0;
         for(int quantity : quantities){
             stores += (quantity + limit - 1)/limit;
             if(stores> n) return false;
         }

        return true;

    }
}

