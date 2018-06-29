import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length;
        //write your code here

        while (left <= right){
            int mid = (right+left)/2;
            if (a[mid]==x){
                return mid;
            }
            if (a[mid]>x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{

        FastScanner scanner = new FastScanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\4_1_binary_search.in"));
//        FastScanner scanner = new FastScanner(System.in);
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

        int counter =0;
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
//            System.out.print(binarySearch(a, b[i]) + " ");
            if (binarySearch(a, b[i])>=0){
                counter++;
            }

        }
        System.out.println("counter = " + counter);
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
