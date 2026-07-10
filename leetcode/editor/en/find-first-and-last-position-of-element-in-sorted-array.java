class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Khởi tạo mảng mặc định nếu không tìm thấy target
        int[] result = new int[]{-1, -1};

        // Tìm vị trí đàu tiên bên trái
        result[0] = findBound(nums, target, true);

        // Chỉ tìm vị trí bên phải nếu tồn tại vị trí bên trái
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }

        return result;
    }

    private int findBound(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Vị trí tiềm năng
                if (isLeft) {
                    right = mid - 1; // Nếu tìm vị trí đầu thì thu hẹp right
                } else {
                    left = mid + 1; // Nếu tìm vị trí cuối thì thu hẹp left
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return bound;
    }
}
