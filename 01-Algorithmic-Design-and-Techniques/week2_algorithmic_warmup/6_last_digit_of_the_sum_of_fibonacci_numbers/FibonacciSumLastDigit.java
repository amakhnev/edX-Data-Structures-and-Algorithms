import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSum(long n) {
        long reminder = n % getPisanoPeriod(10);

        if (reminder <= 1)
            return reminder;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < reminder - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            sum = (sum + current) % 10;
        }

        return sum;
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
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

