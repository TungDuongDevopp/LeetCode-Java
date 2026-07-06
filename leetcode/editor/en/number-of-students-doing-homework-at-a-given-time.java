class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // Tạo mảng hiệu (thời gian từ 1 -> 100, kích thước 102 để tránh tràn khi + 1)
        int[] diff = new int[1002];

        // 1. Đánh dấu biến động: thêm 1 học sinh và bớt 1 học sinh
        for (int i = 0; i < startTime.length; i++) {
            diff[startTime[i]] += 1;       // Có thêm 1 học sinh bắt đầu làm bài
            diff[endTime[i] + 1] -= 1;     // Hết giờ, bớt đi 1 học sinh
        }

        // 2. Cộng dồn toàn bộ mảng từ trái sang phải
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }

        // 3. Trả về số lượng học sinh tại đúng thời điểm queryTime
        return diff[queryTime];
    }
}
