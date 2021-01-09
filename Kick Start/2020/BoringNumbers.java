import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();

        for(int i = 1; i <= t; i++) {
            long l = input.nextLong();
            long r = input.nextLong();

            long output = boringNumbersCalculate(l,r);
            System.out.print("Case #" + i + ": " + output + "\n");
        }
    }

    public static long boringNumbersCalculate(long left, long right) {
        long rightSum = 0;
        long leftSum = 0;

        // Calculating boring numbers from 1 to right -> [1,R]
        for(long i = 1; i <= right; i = i*10) {
            if(i*10 - 1 <= right) {
                long x = (i/10) + 1;
                double result = Math.pow(5, x);
                rightSum += (long) result;
            }
            else {
                rightSum += smallInterval(i, right);
            }
        }

        // Calculating boring numbers from 1 to Left -> [1,L-1]
        for(long i = 1; i <= left-1; i = i*10) {
            if(i*10 - 1 <= left-1) {
                long x = (i/10) + 1;
                double result = Math.pow(5, x);
                leftSum += (long) result;
            }
            else {
                leftSum += smallInterval(i, left-1);
            }
        }

        return rightSum - leftSum;
    }

    public static int smallInterval(long left, long right) {
        ArrayList<Long> numbers = new ArrayList<>();
        int count = 0;

        for(long i = left; i <= right; i++)
            numbers.add(left++);

        for(int i = 0; i < numbers.size(); i++) {
            String number = Long.toString(numbers.get(i));
            char[] list = number.toCharArray();

            int counter = 0;

            for(int j = 1; j <= number.length(); j++) {
                int item = Character.getNumericValue(list[j-1]);

                if((j % 2 == 1 && item % 2 == 1) || (j % 2 == 0 && item % 2 == 0)) {
                    counter++;
                }
                else {
                    break;
                }
            }

            if(counter == number.length())
                count++;
        }

        return count;
    }


}
