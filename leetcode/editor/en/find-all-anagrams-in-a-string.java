
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     //Khai báo list
        List<Integer>list = new ArrayList<>();

     //Kiểm tra điều kiện
        if(p.length()>s.length()) return list;

     //Khai báo con trỏ
        int left = 0;
     //Khai báo mảng đếm
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

      //Cho kí tự trong mảng p vào mảng đếm
        for(char c : p.toCharArray()){
          arr1[c-'a']++;
      }
      //Khởi tạo cửa sổ
        for(int right = 0 ;right<s.length();right++){
            char cright = s.charAt(right);

            //Mở rộng cửa sổ
            arr2[cright-'a']++;
            //Vi phạm điều kiện thì thu nhỏ cửa sổ
            if(right-left+1>p.length()){
                char cleft = s.charAt(left);
                arr2[cleft-'a']--;
                left++;
            }
            //Kiểm tra xem chuỗi con s có phải ana của p k
            if(isEqual(arr1,arr2)){
                list.add(left);
            }
        }
        return list;
    }
    private boolean isEqual(int[] arr1,int[] arr2){
        for (int i = 0;i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}

