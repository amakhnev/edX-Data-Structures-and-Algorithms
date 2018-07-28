import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();

        int prime = 1000000007;
        int multiplier = 263;
        int multiplierPowM = 1;
        for (int i=0;i<m;i++){
            multiplierPowM = multiplierPowM*multiplier%prime;
        }


        int [] hashes = new int[n-m+1];
        hashes[n-m] = polyHash(t.substring(n-m),prime,multiplier);
        for (int i=n-m-1;i>=0;i--){
            hashes[i] = (int)((long)hashes[i+1]*multiplier+t.charAt(i)-(long)t.charAt(i+m)*multiplierPowM)%prime;
        }
        int hash = polyHash(s,prime,multiplier);


        List<Integer> occurrences = new ArrayList<>();
        for (int i = 0; i + m <= n; ++i) {
            if (hashes[i]-hash==0){
                boolean equal = true;
                for (int j = 0; j < m; ++j) {
                    if (s.charAt(j) != t.charAt(i + j)) {
                        equal = false;
                        break;
                    }
                }
                if (equal)
                    occurrences.add(i);
            }

    	}
        return occurrences;
    }

    private static int polyHash(String s, int prime , int multiplier ) {
        long result =0;
        for (int i=s.length()-1;i>=0;i--) {
            result = (result*multiplier + s.charAt(i))%prime;
        }
        return (int) result;
    }


    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

