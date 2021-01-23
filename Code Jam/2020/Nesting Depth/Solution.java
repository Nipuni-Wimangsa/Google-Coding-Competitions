import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();
        String space = input.nextLine();

        for(int testCase = 1; testCase <= t; testCase++) {
            String s = input.nextLine();
            s = "0" + s + "0";

            String output = nestingDepth(s);

            System.out.println("Case #" + testCase + ": " + output);
        }
    }


    public static String nestingDepth(String s) {
        String output = "";

        for(int index = 1; index < s.length(); index++) {
            char ch1 = s.charAt(index);
            char ch2 = s.charAt(index-1);

            if(ch1 == ch2) output += ch1;

            else if(ch1 > ch2) {
                for(int p = 1; p <= ch1 - ch2; p++)
                    output += "(";

                output += ch1;
            }

            else {
                for(int p = 1; p <= ch2 - ch1; p++)
                    output += ")";

                output += ch1;
            }
        }

        return output.substring(0,output.length()-1);
    }
}
