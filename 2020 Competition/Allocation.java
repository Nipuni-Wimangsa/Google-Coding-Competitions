import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int testCases = input.nextInt();
        
        for(int i = 1; i <= testCases; i++) {
            
            int noHouses = input.nextInt();
            int budget = input.nextInt();
            int[] houses = new int[noHouses];
            
            for(int j = 0; j < houses.length; j++) {
                houses[j] = input.nextInt();
            }
            
            int count = solve(houses, budget);
            System.out.printf("Case #%d: %d\n", i, count);
        }
    }
    
    public static int solve(int[] h, int b) {
        Arrays.sort(h);
        int sum = 0;
        int count = 0;
        
        for(int i = 0; i < h.length; i++) {
            if((sum + h[i]) <= b){
                sum += h[i];
                count += 1;
            }
            else{
                break;
            }
        }
        
        return count;
    }

}
