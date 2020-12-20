import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for(int i = 1; i <= t; i++){
            int nS = input.nextInt();
            int nP = input.nextInt();
            int dP = input.nextInt();

            int[][] array = new int[nS][nP];

            for(int j = 0; j < nS; j++){
                for(int k = 0; k < nP; k++){
                   array[j][k] = input.nextInt();
                }
            }

            int beautySum = solve(array, dP, nP);

            System.out.printf("Case #%d: %d\n", i, beautySum);

        }
    }

    private static int sum(int[][] array, int sN, int nP){
        int sum = 0;

        for(int i = 0; i < nP; i++){
            sum += array[sN][i];
        }

        return sum;
    }

    private static int solve(int[][] array, int dP, int nP) {
        int summation = 0;
        int temp;

        for (int i = 0; i < (array.length) - 1; i++) {
            for (int j = dP - nP; j < dP; j++) {
                for (int k = 1; k < array.length; k++) {

                    if((dP - j) >= (dP - nP)){
                        temp = sum(array, i, j) + sum(array, k, dP - j);
                        if (temp > summation) {
                            summation = temp;
                        }
                    }

                }
            }
        }

        return summation;
    }
}
