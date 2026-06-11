
import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
     if (s.isBlank() || s == null) return true;

     int left =  0;
     int right = s.length()-1;
     while(left< right){
         char cleft = s.charAt(left);
         char cright = s.charAt(right);
         if(!Character.isLetterOrDigit(cleft)) {
             left ++;
         }

         else if(!Character.isLetterOrDigit(cright)) {
             right--;
         }
         else{
              if(Character.toLowerCase(cleft)!=Character.toLowerCase(cright)) return false;
              left ++;
              right --;
         }
     }
     return true;
    }
}

