
import java.util.*;

class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        // Khởi tạo biến số quả ít nhất và nhiều nhất trong 1 nải
        int minimum = 1;
        int maximum = 1;

        //Tiến hành tìm số quả nhiều nhất trong 1 nải
        for(int pile : piles){
            maximum = Math.max(maximum,pile);
        }
        //Khởi tạo tốc độ nhỏ nhất bằng maximum ban đầu

        //Tiến hành duyệt tốc độ ăn
        while(minimum<=maximum){
            int average = minimum + (maximum - minimum)/2;
            // Nếu tìm được tốc độ, cố gắng giảm tốc độ tìm đáp án tối ưu nhất
            if(checkSpeed(piles,average,h)){
                //Tiến hành lùi max
                maximum = average -1;
            }
            //Nếu không tìm được phải tăng tốc độ lên
            else{
                minimum = average+1;
            }

        }

        // Trả về kết quả
        return minimum;
    }
    // Khởi tạo hàm check tốc độ
    private boolean checkSpeed(int [] piles,int speed,int hour){
        // Khởi tạo biến tính giờ
        long hourTotal = 0;
        for (int pile : piles){
            hourTotal += (pile + speed - 1)/speed;
            if(hourTotal > hour)
                return false;
        }
        return hourTotal<=hour;
    }
}


