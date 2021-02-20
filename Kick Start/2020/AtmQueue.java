import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte t = input.nextByte();

        for(int testCase = 1; testCase <= t; testCase++) {
            long n = input.nextLong();
            long x = input.nextLong();

            Queue<Long> atmQueue = new ArrayDeque<>();
            Queue<Long> numbers = new ArrayDeque<>();

            for (long i = 1; i <= n; i++) {
                atmQueue.add(input.nextLong());
                numbers.add(i);
            }

            Queue<Long> output = new ArrayDeque<>();

            while (!atmQueue.isEmpty()) {
                if(atmQueue.peek() <= x) {
                    atmQueue.remove();
                    output.add(numbers.peek());
                    numbers.remove();
                }
                else {
                    long amount = atmQueue.peek();
                    long number = numbers.peek();
                    atmQueue.remove();
                    numbers.remove();
                    atmQueue.add(amount-x);
                    numbers.add(number);
                }
            }

            System.out.print("Case #" + testCase + ":");

            for(int i = 1; i <= n; i++) {
                if(!output.isEmpty()) System.out.print(" ");
                System.out.print(output.peek());
                output.remove();
            }

            System.out.println();
        }
    }
}
