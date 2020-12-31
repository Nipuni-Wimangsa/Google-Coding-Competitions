import java.util.Scanner;

public class Solution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte t = input.nextByte();

        for(byte i = 1; i <= t; i++) {
            int n = input.nextInt();
            long x = input.nextInt();

            long[] array = new long[n];

            for(int j = 0; j < n; j++) {
                array[j] = input.nextLong();
            }

            int[] answer = AtmQueue(array, x);
            System.out.printf("Case #%d: ", i);

            for(int j = 0; j < n; j++) {
                System.out.print(answer[j]);
                if(j != n-1){
                    System.out.print(" ");
                }
                else {
                    System.out.print("\n");
                }
            }

        }

    }

    public static int[] AtmQueue(long[] array, long x) {
        int n = array.length;

        long[] xRemainder = new long[n];
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {

            if(x == 1){
                xRemainder = array;
                break;
            }
            
            else {
                if(array[i] % x == 0) {
                    xRemainder[i] = 1;
                }
                else {
                    xRemainder[i] = array[i]/x + 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            answer[i] = i+1;
        }

        for(int i = 0; i <= n-2; i++) {
            for(int j = i+1; j <= n-1; j++) {

                if(xRemainder[i] > xRemainder[j]) {
                    long temp1 = xRemainder[i];
                    xRemainder[i] = xRemainder[j];
                    xRemainder[j] = temp1;

                    int temp2 = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp2;
                }

                if((xRemainder[i] == xRemainder[j]) && (answer[i] > answer[j])) {
                    int temp3 = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp3;
                }
            }
        }

        return answer;
    }
}
