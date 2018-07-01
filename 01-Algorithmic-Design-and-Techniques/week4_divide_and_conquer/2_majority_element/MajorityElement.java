import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a) {

        HashMap<Integer,Integer> counter = new HashMap<>();
        for (int i = 0;i<a.length;i++){
            if (counter.containsKey(a[i])){
                counter.replace(a[i],counter.get(a[i])+1);
            }else{
                counter.put(a[i],1);
            }
        }

        for (int key :
                counter.keySet()) {
            if (counter.get(key)>a.length/2){
                return key;
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
        int max = getMajorityElement(a);
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

