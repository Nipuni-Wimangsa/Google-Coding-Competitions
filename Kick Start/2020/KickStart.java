import java.util.Scanner;

public class Solution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte t = input.nextByte();

        for(byte i = 1; i <= t; i++) {
            String text = input.next();
            int output = countWord(text);
            System.out.printf("Case #%d: %d\n", i, output);
        }

    }

    public static int countWord(String str) {
        str = str.toUpperCase();

        char[] strArray = str.toCharArray();
        int count = 0;
        int answer = 0;

        for(int i = 0; i <= strArray.length - 5; i++) {
            if(str.substring(i, i+4).equals("KICK")) {
                count++;
            }
            
            if(str.substring(i, i+5).equals("START")) {
                answer += count;
            }
        }
        return answer;
    }
}
