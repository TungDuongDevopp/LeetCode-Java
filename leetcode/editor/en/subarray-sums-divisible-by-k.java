class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Mảng lưu tần suất xuất hiện của các số dư (thay cho HashMap)
        int[] remainderCount = new int[k];

        // Khởi tạo số dư 0 xuất hiện 1 lần (tương đương map.put(0, 1))
        remainderCount[0] = 1;

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Chuẩn hóa số dư luôn dương
            int rem = (prefixSum % k + k) % k;

            // Cộng thêm số subarray được tạo ra bởi số dư đã gặp trước đó
            count += remainderCount[rem];

            // Tăng tần suất xuất hiện của số dư này lên 1
            remainderCount[rem]++;
        }

        return count;
    }
}
