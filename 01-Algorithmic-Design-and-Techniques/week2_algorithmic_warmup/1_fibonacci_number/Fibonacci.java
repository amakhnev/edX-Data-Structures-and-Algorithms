import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib_rec(int n) {
    if (n <= 1)
      return n;

    return calc_fib_rec(n - 1) + calc_fib_rec(n - 2);
  }


  private static long calc_fib(int n) {
      if (n <= 1)
          return n;

      long first = 1;
      long second =1;

      for (int i=3;i<=n;i++){
          long next = first+second;
          first = second;
          second = next;
      }
      return second;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
