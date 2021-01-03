import java.util.Scanner;

public class Solution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte t = input.nextByte();

        for (byte i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[] visitors = new int[n];

            for(int j = 0; j < n; j++) {
                visitors[j] = input.nextInt();
            }

            int output = recordBreaker(visitors);
            System.out.printf("Case #%d: %d\n", i, output);
        }
    }

    public static int recordBreaker(int[] visitors) {
        int maxBreaker = visitors[0];
        int count = 0;
        int n = visitors.length;

        if(n != 1) {
            if(visitors[0] > visitors[1]) {
                count++;
            }

            for(int i = 1; i < n - 1; i++) {
                if(maxBreaker < visitors[i] && visitors[i] > visitors[i+1]){
                    maxBreaker = visitors[i];
                    count++;
                }

                if(i+1 == n-1 && visitors[i+1] > maxBreaker)
                    count++;
            }
        }

        else {
            count = 1;
        }

        return count;
    }
}
