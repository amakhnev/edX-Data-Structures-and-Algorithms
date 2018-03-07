import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        int max = 0;
        int secondmax = 0;

        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i]>=max) {
                secondmax = max;
                max = numbers[i];
            }else if (numbers[i]>=secondmax){
                secondmax = numbers[i];
            }
        }
        return (long)max*secondmax;
    }

    public static void main(String[] args) {
        mainManual();
//        mainGen();
//        mainStress(10,10000);
    }

    public static void mainGen() {
        int size = 20000;
        int[] numbers = new int[size];

        for (int i =0; i <size; i++){
            numbers[i] = i+1;
        }

        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    public static void mainStress(int n, int m) {


        while (true){
            int size = 2 + (int) (Math.random()*(n-1));

            int[] numbers = new int[size];

            for (int i =0; i <size; i++){
                numbers[i] = (int) (Math.random()*(m+1));
            }

            if (getMaxPairwiseProductFast(numbers) == getMaxPairwiseProduct(numbers)){
                System.out.println("OK");
            }else{
                System.out.println("Wrong answer! "+numbers);
                return;
            }
        }
    }

    public static void mainManual() {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}