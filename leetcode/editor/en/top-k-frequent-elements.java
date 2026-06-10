
import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map  = new HashMap<>();
        for(int i : nums){
            map.merge(i,1,Integer::sum);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int num : map.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Xóa phần tử có tần suất thấp nhất
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
