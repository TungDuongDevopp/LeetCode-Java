class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        // Bước 1: Đánh dấu điểm đầu và điểm cuối của từng hàng booking
        for (int[] booking : bookings) {
            int start = booking[0] - 1; // Đổi sang 0-indexed
            int end = booking[1] - 1;   // Đổi sang 0-indexed
            int seats = booking[2];

            ans[start] += seats;       // Cộng tại điểm bắt đầu
            if (end + 1 < n) {
                ans[end + 1] -= seats; // Trừ tại điểm ngay sau điểm kết thúc
            }
        }

        // Bước 2: Cộng dồn (Prefix Sum) để khôi phục lại mảng kết quả ban đầu
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}
