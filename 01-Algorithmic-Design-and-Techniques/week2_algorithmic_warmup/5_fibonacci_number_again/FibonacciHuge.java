import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {

        long reminder = n % getPisanoPeriod(m);

        if (reminder <= 1)
            return reminder;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < reminder - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current;
    }

    private static long getPisanoPeriod(long m) {
        long a = 0;
        long b = 1;

        for (int i = 0; i < m * m; i++) {
            long c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

