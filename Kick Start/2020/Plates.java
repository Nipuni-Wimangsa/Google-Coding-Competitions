import java.util.Scanner;

public class Solution {
	static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte t = input.nextByte();

        for(int i = 1; i <= t; i++) {
            byte stacks = input.nextByte();
            byte plates = input.nextByte();
            short dPlates = input.nextShort();

            solution(stacks, plates, dPlates);
        }


    }

    private static int solution(byte stacks, byte plates, short dPlates) {
        byte n = stacks;
        byte k = plates;
        short p = dPlates;

        byte[][] array = new byte[n][k];

        for(byte i = 0; i < n; i++) {
            for(byte j = 0; j < k; j++) {
                array[i][j] = input.nextByte();
            }
        }

        int[][] sum = new int[n][k+1];

        for(int i = 0; i < n; i++) {
            int summation = 0;

            for(int j = 0; j < k; j++) {
                summation += array[i][j];
                sum[i][j+1] = summation;
            }
        }



        return 0;
    }

}
