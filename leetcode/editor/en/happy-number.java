
import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && getNext(fast) != 1 && slow != fast) {
            slow = getNext(slow);         // Rùa đi 1 bước
            fast = getNext(getNext(fast)); // Thỏ đi 2 bước
        }
        return fast == 1 || getNext(fast) == 1;
    }
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }
}

