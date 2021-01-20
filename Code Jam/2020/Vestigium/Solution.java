import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();

        for(int i = 1; i <= t; i++) {
            byte n = input.nextByte();
            byte[][] matrix = new byte[(int) n][(int) n];

            for(byte row = 0; row < n; row++)
                for(byte column = 0; column < n; column++)
                    matrix[row][column] = input.nextByte();

            int trace = calculateTrace(matrix);
            int numberOfRepeatedRows = repeatRows(matrix);
            int numberOfRepeatedCols = repeatCols(matrix);

            System.out.println("Case #" + i + ": " + trace + " " + numberOfRepeatedRows + " " + numberOfRepeatedCols);
        }
    }

    private static int calculateTrace(byte[][] matrix) {
        int trace = 0;

        for(byte row = 0; row < matrix.length; row++)
            for(byte column = 0; column < matrix.length; column++)
                if(row == column)
                    trace += (matrix[row][column]);

        return trace;
    }

    private static int repeatRows(byte[][] matrix) {
        int rows = 0;

        for(byte row = 0; row < matrix.length; row++) {
            Map<Byte, Byte> map = new HashMap();

            for(byte column = 0; column < matrix.length; column++) {
                if(map.containsValue(matrix[row][column])) {
                    rows++;
                    break;
                }
                else map.put(column, matrix[row][column]);
            }

        }

        return rows;
    }

    private static int repeatCols(byte[][] matrix) {
        int cols = 0;

        for(byte column = 0; column < matrix.length; column++) {
            Map<Byte, Byte> map = new HashMap();

            for(byte row = 0; row < matrix.length; row++) {
                if(map.containsValue(matrix[row][column])) {
                    cols++;
                    break;
                }
                else map.put(row, matrix[row][column]);
            }

        }

        return cols;
    }

}
