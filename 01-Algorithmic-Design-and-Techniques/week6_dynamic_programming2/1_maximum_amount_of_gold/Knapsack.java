import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {

        int [][] values = new int[w.length+1][W+1];

        for (int i=1;i<=w.length;i++){
            for (int j=1;j<=W;j++){
                if (j-w[i-1]>=0){
                    values[i][j] = Math.max(values[i-1][j],values[i-1][j-w[i-1]]+w[i-1]);
                }else{
                    values[i][j] = values[i-1][j];
                }

            }
        }
        return values[w.length][W];
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\6_1_knapsack.in"));
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

