import java.util.Scanner;

public class Solution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte t = input.nextByte();

        for(byte i = 1; i <= t; i++) {
            byte checkPoints = input.nextByte();
            byte[] heights = new byte[checkPoints];

            for(byte j = 0; j < checkPoints; j++) {
                heights[j] = input.nextByte();
            }

            int peaks = solution(heights);

            System.out.printf("Case #%d: %d\n", i, peaks);
        }
    }

    public static byte solution(byte[] heights) {
        byte peaks = 0;

        for(byte i = 1; i < heights.length - 1; i++) {
            if(heights[i-1] < heights[i] && heights[i+1] < heights[i]) {
                peaks++;
            }
        }
        return peaks;
    }

}
