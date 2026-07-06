
import java.util.*;

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {

        //Tạo mảng diff
        int [] diff = new int[102];

        for(List<Integer> num : nums){
            int start = num.get(0);
            int end = num.get(1);
            diff[start]++;
            diff[end+1]--;
        }
        for (int i = 1;i<diff.length;i++){
            diff[i]+=diff[i-1];
        }
        return (int)Arrays.stream(diff).filter(n->n>0).count();
    }
}

