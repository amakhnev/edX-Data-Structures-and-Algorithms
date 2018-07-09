import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int [][]values = new int[a.length+1][b.length+1]; // assume first roq and column filled with 0s

        for (int i=0;i<a.length;i++){
            for (int j=0;j<b.length;j++){
                values[i+1][j+1] = Math.max(Math.max(values[i][j+1],values[i+1][j]), values[i][j] + (a[i]==b[j]?1:0));
            }
        }

        return values[a.length][b.length];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\5_4_lcs2.in"));
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

