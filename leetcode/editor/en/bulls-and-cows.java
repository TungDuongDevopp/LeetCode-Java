
import java.util.*;
        class Solution {
            public String getHint(String secret, String guess) {
                int bulls = 0;
                int cows = 0;
                // Mảng đếm cho các chữ số từ '0' đến '9'
                int[] count = new int[10];

                for (int i = 0; i < secret.length(); i++) {
                    char s = secret.charAt(i);
                    char g = guess.charAt(i);

                    if (s == g) {
                        // 1. Nếu trùng khớp hoàn toàn tại vị trí i -> Chắc chắn là Bulls
                        bulls++;
                    } else {
                        // 2. Nếu không khớp, xử lý Cows dựa trên dấu của mảng đếm

                        // s là ký tự của secret: nếu count[s] < 0 nghĩa là guess đã từng đoán số này
                        if (count[s - '0'] < 0) {
                            cows++;
                        }
                        // g là ký tự của guess: nếu count[g] > 0 nghĩa là secret đã từng có số này
                        if (count[g - '0'] > 0) {
                            cows++;
                        }

                        // Cập nhật mảng đếm: secret tăng (++), guess giảm (--)
                        count[s - '0']++;
                        count[g - '0']--;
                    }
                }

                // Trả về kết quả theo định dạng "xAyB"
                return bulls + "A" + cows + "B";
            }
        }





