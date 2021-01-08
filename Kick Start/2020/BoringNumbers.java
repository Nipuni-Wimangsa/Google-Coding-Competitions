import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();

        for(int i = 1; i <= t; i++) {
            int l = input.nextInt();
            int r = input.nextInt();

            int output = calculatingBoringNumbers(l,r);
            System.out.print("Case #" + i + ": " + output + "\n");
        }
    }

    public static int calculatingBoringNumbers(int left, int right) {
        int[] numbers = new int[right - left + 1];
        int count = 0;

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = left++;
        }

        for(int i = 0; i < numbers.length; i++) {
            String number = Integer.toString(numbers[i]);
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
