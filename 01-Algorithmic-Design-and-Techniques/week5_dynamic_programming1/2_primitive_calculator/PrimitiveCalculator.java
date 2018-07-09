import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int [][] values = new int[n+1][2];
        for (int i=1;i<=n;i++){
            int minValue = values[i-1][0]+1;
            int minIdx = i-1;

            if ( i%3 == 0){
                if (values[i/3][0]+1 < minValue){
                    minValue = values[i/3][0]+1;
                    minIdx = i/3;
                }
            }
            if ( i%2 == 0){
                if (values[i/2][0]+1 < minValue){
                    minValue = values[i/2][0]+1;
                    minIdx = i/2;
                }
            }

            values[i][0] = minValue;
            values[i][1] = minIdx;
        }

        List<Integer> sequence = new ArrayList<Integer>();
        while (n>0){
            sequence.add(n);
            n = values[n][1];
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

