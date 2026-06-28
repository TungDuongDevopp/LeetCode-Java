
import java.util.*;
class Solution {
    public int totalFruit(int[] fruits) {
        Map <Integer,Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Thêm phần tử bên phải vào cửa sổ
            map.merge(fruits[right],1,Integer::sum);

            // Thu nhỏ cửa sổ từ bên trái nếu số lượng phần tử khác nhau vượt quá k
            while (map.size() > 2 && left<= right ) {
                map.merge(fruits[left],-1,Integer::sum);
                if(map.get(fruits[left])==0) map.remove(fruits[left]);
                left++;
            }
            // Cộng dồn số lượng mảng con hợp lệ kết thúc tại 'right'
            maxLen =  Math.max(maxLen,right-left+1);
        }

        return maxLen;
    }

}

