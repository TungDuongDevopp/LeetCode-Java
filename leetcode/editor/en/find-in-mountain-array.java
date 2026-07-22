
import java.util.*;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Bước 1: Tìm đỉnh núi
        int peak = findPeakIndex(mountainArr, 0, n - 1);

        // Bước 2: Tìm kiếm nhị phân bên nửa tăng dần (isAscending = true)
        int leftResult = binarySearch(mountainArr, target, 0, peak, true);
        if (leftResult != -1) {
            return leftResult;
        }

        // Bước 3: Tìm kiếm nhị phân bên nửa giảm dần (isAscending = false)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }


    private int findPeakIndex(MountainArray arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Hàm tìm kiếm nhị phân tổng quát cho cả 2 hướng
    private int binarySearch(MountainArray arr, int target, int low, int high, boolean isAscending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);

            if (val == target) {
                return mid;
            }

            // Logic đảo chiều dựa trên biến isAscending
            if (isAscending) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val > target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}

