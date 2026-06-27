
import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {

        // Nếu độ dài của mảng  =  1 return 1 bất kể k bao nhiêu
        if (s.length() == 1) return 1;

        //Khai báo con trỏ left
        int left = 0;

        //Khai báo mảng đếm
        int[] count  = new int[26];

        //Khai báo biến đo độ dài
        int maxLen = 0;

        //Khai báo biến đếm phần tử có số lượng lớn nhat
        int maxFre  = 0;
        //Khai báo cửa sổ trượt
        for(int right = 0; right<s.length();right++){

            char cright = s.charAt(right);
            //Thêm vào mảng đếm
            count[cright-'A']++;

            // Cập nhat max fre khi cho phần tử vào mảng đếm
            maxFre = Math.max(maxFre,count[cright-'A']);

            //Cửa sổ bị vi phạm khi windowlength - max> k
            while(right-left+1 - maxFre > k){
                char cleft = s.charAt(left);
                count[cleft-'A']--;
                maxFre = Math.max(maxFre,count[cleft-'A']);
                left++;
            }
            // Cập nhật độ dài lớn nhất
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

}



