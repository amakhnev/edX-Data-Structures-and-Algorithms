import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, new Comparator<String>() { // ("9"<"8") and ("92" < "928")
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == 0 || o2.length() == 0) {
                    if (o1.length() > 0) return 1;
                    if (o2.length() > 0) return -1;
                    return 0;
                }
                if (o1.charAt(0) == o2.charAt(0)) {
                    return this.compare(o1.substring(1), o2.substring(1));
                } else {
                    if (o1.charAt(0) > o2.charAt(0)) return -1;
                    if (o1.charAt(0) < o2.charAt(0)) return 1;
                }
                return 0;
            }
        });

        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

