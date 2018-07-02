import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {

        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        
        int leftMax = getMajorityElement(a,left,(right+left)/2);
        if (leftMax>0){
            int counter =0;
            for (int i=0;i<a.length;i++){
                if (a[i]==leftMax){
                    counter++;
                    if (counter>a.length/2){
                        return leftMax;
                    }
                }
            }
        }
        int rightMax = getMajorityElement(a,(right+left)/2,right);
        if (rightMax>0){
            int counter =0;
            for (int i=a.length-1;i>=0;i--){
                if (a[i]==rightMax){
                    counter++;
                    if (counter>a.length/2){
                        return rightMax;
                    }
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\4_2_majority_element.in"));

//        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int max = getMajorityElement(a,0, a.length);
        if (max != -1) {
            System.out.println(max);
        } else {
            System.out.println(0);
        }
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

