
import java.util.*;

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if(countLessOrEqual(mid,m,n,k)){
                high=mid;
            }
            else {
                // Không đủ k số <= mid, mid này quá bé, đáp án phải nằm bên phải
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean countLessOrEqual(int mid, int m, int n,int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count>=k;
    }
}

