
import java.util.*;

class NumMatrix {

    private final int[][] prefix;

    public NumMatrix(int[][] matrix) {

       int maxRow = matrix.length+1;
       int maxCol = matrix[0].length+1;

       //Khởi tạo matrix prefix
        prefix = new int[maxRow][maxCol];
       //Duyệt matrix
        for(int row = 1;row<maxRow;row++){
            for(int col = 1;col<maxCol;col++){
                prefix[row][col] = prefix[row-1][col]
                                   + prefix[row][col-1]
                                   - prefix[row-1][col-1]
                                   + matrix[row-1][col-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return  prefix[row2+1][col2+1]
                - prefix[row2+1][col1]
                - prefix[row1][col2+1]
                + prefix[row1][col1];

    }
}


