
import java.util.*;

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int minSpeed = -1;
        if (hour <= (double) dist.length - 1.0) {
            return -1;
        }
        int right = 10000000;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(checkSpeed(dist,hour,mid)){
                 minSpeed = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return minSpeed;

    }
    private boolean checkSpeed(int[] dist, double hour, int speed){
        double totalTime = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            //Làm tròn thời gian trừ chuyến cuối
            totalTime += (dist[i] + speed - 1)/speed;
        }
        // Chuyến cuối không phải tốn thời gian đợi do đã đến đích
        totalTime += (double) dist[dist.length - 1] / speed;
        return totalTime <= hour;
    }
}
