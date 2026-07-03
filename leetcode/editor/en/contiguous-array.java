import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store the first occurrence of a running sum: <Running Sum, Index>
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, and 1 as +1
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            // If the map already contains this sum, calculate the distance
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                // Only store the first occurrence to maximize the subarray length
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
