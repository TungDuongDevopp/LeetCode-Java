
import java.util.*;

class Solution {
    private int count = 0;
    private int lower;
    private int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;

        // Khởi tạo mảng prefix
        long [] prefix = new long[nums.length+1];
        for(int i =0;i<nums.length;i++){
            prefix[i+1] = nums[i]+ prefix[i];
        }
        mergeSort(prefix, 0, prefix.length - 1);
        //Trả về kết quả
        return count;
    }
    private void mergeSort(long[] prefix, int left, int right) {
        if (left >= right) return;

        //Tính chỉ số mid
        int mid = left + (right - left) / 2;
        //Gọi đệ quy hàm mergeSort cho đến khi chia làm 2 nửa tự sắp xếp
        mergeSort(prefix, left, mid);
        mergeSort(prefix, mid + 1, right);

        // Bước đếm cặp bằng hai con trỏ trước khi trộn mảng
        int low = left;
        int high = left;
        // Chạy j từ vị trí nửa phải
        for (int j = mid + 1; j <= right; j++) {
            // Tìm vị trí đầu tiên bên nửa trái thỏa mãn: prefix[j] - upper <= prefix[low]
            while (low <= mid && prefix[j] - upper > prefix[low]) {
                low++;
            }
            // Tìm vị trí đầu tiên bên nửa trái vượt quá giới hạn: prefix[j] - lower < prefix[high]
            while (high <= mid && prefix[j] - lower >= prefix[high]) {
                high++;
            }
            // Số lượng phần tử hợp lệ ở nửa trái chính là khoảng cách giữa 2 con trỏ
            count += (high - low);
        }

        // Trộn hai mảng đã sắp xếp (bước Merge thông thường của Merge Sort)
        merge(prefix, left, mid, right);
    }
    private void merge(long[] prefix, int left, int mid, int right) {
        long[] temp = new long[right - left + 1]; // Mảng tạm để chứa kết quả trộn
        int i = left;     // Con trỏ  i chạy ở nửa trái
        int j = mid + 1; // Con trỏ jchạy ở nửa phải
        int k = 0;        // Chỉ số của mảng tạm 'temp'


        while (i <= mid && j <= right) {
            // So sánh từng cặp phần tử ở 2 nửa, thằng nào nhỏ hơn thì xếp vào mảng 'temp' trước và tăng chỉ số lên 1 đv
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }
        // Nếu nửa trái còn dư phần tử, ném nốt vào 'temp'
        while (i <= mid) temp[k++] = prefix[i++];
        // Nếu nửa phải còn dư phần tử, ném nốt vào 'temp'
        while (j <= right) temp[k++] = prefix[j++];

        // Copy toàn bộ mảng 'temp' đã được sắp xếp gọn gàng đè ngược lại vào mảng 'prefix' gốc
        System.arraycopy(temp, 0, prefix, left, temp.length);
    }

}

