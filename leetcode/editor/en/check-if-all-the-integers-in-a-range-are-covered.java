
import java.util.*;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff =  new int[52];
        for(int[] nums : ranges){
            int start = nums[0];
            int end = nums[1];
            diff[start]++;
            diff[end+1]--;
        }
        for(int i=1;i<diff.length;i++){
            diff[i]+=diff[i-1];
        }
        for(int i=left;i<=right;i++){
            if(diff[i]==0) return false;
        }
        return true;
    }
}

