
import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        // Có n position, m bóng
        // Tiến hành tìm min-max
        Arrays.sort(position);
        int min = 1,max = position[position.length - 1] - position[0];
        while(min<=max){
            int mid = min + (max-min)/2;
            if(checkDistance(position,m,mid)){
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        return max;
    }
    private boolean checkDistance(int[] position,int m,int distance){
        int count = 1;
        int last = position[0];
        for(int i = 1;i<position.length;i++){

            if(position[i]-last>=distance){
                last = position[i];
                count++;
            }

        }
        return count >=m;
    }
}

