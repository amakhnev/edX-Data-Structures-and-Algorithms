import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int q = m;
        int result = 0;
        if (q >= 10) {
            result += q / 10;
            q = q % 10;
        }

        if (q >= 5) {
            result += q / 5;
            q = q % 5;
        }
        result += q;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

