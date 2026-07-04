
import java.util.*;

class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;
        prefix = new int[R + 1][C + 1];

        // Dựng mảng prefix sum 2D
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                prefix[i][j] = prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1]
                        + matrix[i - 1][j - 1]; // ma trận gốc dùng chỉ số dịch lại 1 đơn vị
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Tính toán dựa trên công thức bù trừ diện tích hình chữ nhật
        return prefix[row2 + 1][col2 + 1]
                - prefix[row1][col2 + 1]
                - prefix[row2 + 1][col1]
                + prefix[row1][col1];
    }
}


