import java.util.Scanner;

public class Solution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte t = input.nextByte();

        for(byte i = 1; i <= t; i++) {
            long n = input.nextInt();
            long k = input.nextInt();
            long s = input.nextInt();

            long restartTime = k + n;
            long previousTime = k + k - s + n - s;
            
            if(restartTime < previousTime) {
                System.out.printf("Case #%d: %d\n", i, restartTime);
            }
            else {
                System.out.printf("Case #%d: %d\n", i, previousTime);
            }
        }
    }

}
