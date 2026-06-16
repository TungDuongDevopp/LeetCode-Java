
import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int min = 0;
        int max = people.length-1;
        int boats = 0;
        if(people.length<2) return 1;
        // Tiến hành sort mảng
        Arrays.sort(people);
        while (min<=max){
            if(people[max]+people[min]<=limit){
                max--;
                min++;
            }
            else{
                max--;
            }
            boats++;

        }
        return boats;
    }
}

