import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int [][][]values = new int[a.length+1][b.length+1][c.length+1]; // assume first roq and column filled with 0s

        for (int i=0;i<a.length;i++){
            for (int j=0;j<b.length;j++){
                for (int k=0;k<c.length;k++){
                    int value = values[i][j][k] + ((a[i]==b[j] && a[i]==c[k])?1:0);

                    if (value < values[i][j+1][k+1] || value < values[i+1][j][k+1] || value < values[i+1][j+1][k] ){
                        value = Math.max(Math.max(values[i][j+1][k+1],values[i+1][j][k+1]),values[i+1][j+1][k]);
                    }

                    values[i+1][j+1][k+1] = value;
                }

            }
        }

        return values[a.length][b.length][c.length];

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\5_5_lcs3.in"));
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

