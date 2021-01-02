import java.util.Scanner;

public class Solution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte t = input.nextByte();

        for (byte i = 1; i <= t; i++) {
            int n = input.nextInt();
            long[] numbers = new long[n];

            for(int j = 0; j < n; j++) {
                numbers[j] = input.nextLong();
            }

            int output = longestArithmeticArray(numbers);
            System.out.printf("Case #%d: %d\n", i, output);
        }
    }

    public static int longestArithmeticArray(long[] numbers) {
        int count = 0;
        int output = 0;
        long difference = numbers[1] - numbers[0];

        for(int i = 0; i < numbers.length-1; i++) {
            if((numbers[i+1] - numbers[i]) == difference) {
                count++;
            }
            else {
                difference = numbers[i+1] - numbers[i];

                if(output < count)
                    output = count;

                count = 1;
            }
        }

        if(output < count)
            output = count;


        return output + 1;
    }
}
