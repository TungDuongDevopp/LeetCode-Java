
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
       //Kiểm tra điều kiện thỏa mãn
            if(t.length()>s.length()) return "";
       // Khai báo con trỏ
            int left = 0;
       // Khai báo biến đếm
            int formed = 0;
       // Khai báo biến độ dài
            int minLen = Integer.MAX_VALUE;
            int start = 0;
       // Khai báo mảng đếm cho chuỗi t,s
            int [] target = new int[128];
            int [] window = new int[128];
       // CHo ký tự  của chuỗi t vào mảng
            for(char c : t.toCharArray()){
               target[c]++;
            }
       // Khai báo biến required
       int required = 0;

       // Đếm số chữ cái khác nhau
        for (int i : target) {
           if(i>0) required++;
        }
        // Khởi tạo cửa sổ
        for(int right = 0 ;right<s.length();right++) {
            //Thêm ký tự vào mảng
            char cright = s.charAt(right);
            window[cright]++;

            // Kiểm tra nếu ký tự thuộc t và đủ số lượng cần thiết
            if(target[cright]>0  && target[cright]==window[cright]) formed++;

            // Thu hẹp cửa sổ khi đủ số lượng chữ cần thiết
            while(formed==required){
                char cleft = s.charAt(left);
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                }
                // Bỏ ký tự bên trái ra khỏi cửa sổ
                window[cleft]--;

                // Kiem tra ký tự thuộc t và sau khi giảm k đủ
                if(target[cleft]>0 && window[cleft]<target[cleft]) formed--;

                left++;

            }

        }
        return (minLen == Integer.MAX_VALUE) ?"":s.substring(start,start+minLen);
    }

}

