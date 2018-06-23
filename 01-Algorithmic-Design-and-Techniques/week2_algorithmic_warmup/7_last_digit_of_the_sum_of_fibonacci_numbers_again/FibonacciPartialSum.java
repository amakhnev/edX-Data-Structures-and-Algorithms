import java.util.*;

public class FibonacciPartialSum {


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
    private static long getFibonacciPartialSum(long from, long to) {
        if (from>to) {
            return getFibonacciPartialSum(to,from);
        }

        long sumFrom =  from>0?getFibonacciSum(from-1):0;
        long sumTo =  getFibonacciSum(to);

        return (sumTo>=sumFrom)?(sumTo-sumFrom):(10+sumTo-sumFrom);

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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

