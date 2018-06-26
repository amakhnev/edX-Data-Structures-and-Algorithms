import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        int current = 1, reminder = n;
        while (reminder >= current) {
            summands.add(current);
            reminder -= current;
            current++;
        }
        if (reminder > 0) {
            summands.set(summands.size() - 1, reminder + summands.get(summands.size() - 1));
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

