
import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int count = 0;

        //Tạo hashmap lưu prefix->frequency
        Map<Integer, Integer> map = new HashMap<>();

        // Cố định cột trái
        for (int c1 = 0; c1 < maxCol; c1++) {
            // Mảng lưu tổng các phần tử của từng hàng từ cột c1 đến c2
            int[] rowSums = new int[maxRow];

            // Cố định cột phải
            for (int c2 = c1; c2 < maxCol; c2++) {
                map.clear();
                map.put(0, 1); // Khởi tạo trường hợp cơ sở như bạn đã hiểu

                int currentSum = 0;
                for (int r = 0; r < maxRow; r++) {
                    // Cộng dồn phần tử tại cột c2 vào hàng tương ứng
                    rowSums[r] += matrix[r][c2];
                    currentSum += rowSums[r];
                    count+=map.getOrDefault(currentSum-target,0);
                    map.merge(currentSum,1,Integer::sum);

                }
            }
        }
        return count;
    }
}

