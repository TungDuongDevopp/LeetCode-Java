class Solution {
    public int maxVowels(String s, int k) {
        int countMax = 0;
        int count = 0;

        // Đếm nguyên âm cho cửa sổ đầu tiên có kích thước k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        countMax = count;

        // Trượt cửa sổ từ vị trí k đến hết chuỗi
        for (int i = k; i < s.length(); i++) {
            // Thêm ký tự mới vào đuôi cửa sổ
            if (isVowel(s.charAt(i))) {
                count++;
            }
            // Loại bỏ ký tự cũ ở đầu cửa sổ ra khỏi đếm
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            // Cập nhật số lượng nguyên âm lớn nhất
            countMax = Math.max(countMax, count);
        }

        return countMax;
    }

    private boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}
