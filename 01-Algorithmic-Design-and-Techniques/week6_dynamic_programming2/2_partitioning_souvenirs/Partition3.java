import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int sum =0;
        int max = 0;
        for (int value:A){
            sum+=value;
            max= Math.max(max,value);
        }
        if (sum%3!=0 || max>sum/3){
            return 0;
        }
        int n = sum/3;

        // values[i][j][k] is representing if it's possible to allocate values from a[0]..a[k]
        // into first bucket with total sum = i and second bucket with sum = j
        boolean [][][] values = new boolean[n+1][n+1][A.length];

        for (int i=0;i<n+1;i++){
            for (int k=0;k<A.length;k++){
                values[i][0][k] = ((i==0)||(A[k]==i));
            }
        }
        for (int j=0;j<n+1;j++){
            for (int k=0;k<A.length;k++){
                values[0][j][k] = ((j==0)||(A[k]==j));
            }
        }


        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                for (int k=0;k<A.length;k++){
                    int value = A[k];
                    boolean isPossible = k>0?values[i][j][k-1]:false; // if we skip value - take previous

                    if (k>0 && value<=i && values[i-value][j][k-1]) { //possible to check if value can be placed into first subset
                        isPossible = true;
                    } else
                    if (k>0 && value<=j && values[i][j-value][k-1]) { //possible to check if value can be placed into second subset
                        isPossible = true;
                    }

                    values[i][j][k]=isPossible;

                }
            }
        }

        return values[n][n][A.length-1]?1:0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

