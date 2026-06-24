
import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Kiểm tra độ dì s1 vs s2
        if(s1.length()>s2.length()) return false;
        // Khai báo con trỏ
        int left = 0;
        //Khai báo mảng đếm
        int [] arr1 = new int [26] ;
        int [] arr2 = new int[26];

        //Đưa các ký tự vào mảng đếm;
       for(char c : s1.toCharArray()){
           arr1[c-'a']++;
       }
       //  Tạo cửa sổ trượt
        for(int right = 0; right<s2.length();right++){
            char cright = s2.charAt(right);
            char cleft = s2.charAt(left);
            // Thực hiện mở rộng cửa sổ
            arr2[cright-'a']++;

            //Vi phạm điều kiện khi chiều dài chuỗi con lớn hơn độ dài chuỗi s1
            if(right-left+1>s1.length()){
                arr2[cleft-'a']--;
                left++;
            }
            // Thực hiện kiểm tra hai mảng
            if(isEqual(arr1,arr2)) return true;
        }
        return false;
    }
    private boolean isEqual(int[] arr1,int[] arr2){
        for (int i = 0;i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}

