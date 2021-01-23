import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();

        for(int testCase = 1; testCase <= t; testCase++) {
           int n = input.nextInt();
           int[][] minutes = new int[n][2];

           for(int i = 0; i < n; i++) {
               for(int j = 0; j < 2; j++) {
                   minutes[i][j] = input.nextInt();
               }
           }

            String output = solve(minutes);
            System.out.println("Case #" + testCase + ": " + output);
        }
    }


    public static String solve(int[][] minutes) {
        int Js = 0, Je = 0;

        int Cs = minutes[0][0];
        int Ce = minutes[0][1];

        String output = "C";

        if(minutes.length > 1) {
           Js = minutes[1][0];
           Je = minutes[1][1];
           output += "J";
        }

        /*
        Cs - Cameron Start Time
        Ce - Cameron End Time
        Js - Jamie Start Time
        Je - Jamie End Time
         */

        for(int i = 2; i < minutes.length; i++) {
            int start = minutes[i][0];
            int end = minutes[i][1];

            if(start >= Ce) {
                output += "C";
                Cs = start;
                Ce = end;
            }
            else if(start >= Je) {
                output += "J";
                Js = start;
                Je = end;
            }
            else if(end <= Cs) output += "C";
            else if(end <= Js) output += "J";
            else output = "IMPOSSIBLE";
        }

        return output;
    }
}
