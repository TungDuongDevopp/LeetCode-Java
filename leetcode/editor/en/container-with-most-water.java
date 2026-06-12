
import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int left= 0;
        int right = height.length-1;
        int max = Math.min(height[left], height[right]) * right;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}

