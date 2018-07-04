import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        // arrays to store point value along with original index in the array, to be sorted later based on values
        int[][] pointsSorted = new int[points.length][2];
        for (int i=0;i<points.length;i++){
            pointsSorted[i][0]=i;
            pointsSorted[i][1]=points[i];
        }

        Arrays.sort(pointsSorted,new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return Integer.compare(o1[1],o2[1]);
                    }
                });
        Arrays.sort(starts);Arrays.sort(ends);

        int idxStarts=0,idxEnds=0, idxPoints =0,numOfSegments=0;

        while (idxPoints < points.length){

            if (idxStarts<starts.length && starts[idxStarts] <= pointsSorted[idxPoints][1] && starts[idxStarts] <= ends[idxEnds]){
                numOfSegments++;idxStarts++;
            }
            else if ((idxStarts==starts.length || pointsSorted[idxPoints][1] <= starts[idxStarts])
                    && (idxEnds==ends.length || pointsSorted[idxPoints][1] <= ends[idxEnds])){
                cnt[pointsSorted[idxPoints][0]]=numOfSegments;
                idxPoints++;
            }
            else if (idxEnds < ends.length && ends[idxEnds] <= pointsSorted[idxPoints][1] && (idxStarts==starts.length || ends[idxEnds] <= starts[idxStarts]) ){
                numOfSegments--;idxEnds++;
            }

        }

        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\4_5_lottery.in"));
//        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
//        int[] cnt = naiveCountSegments(starts, ends, points);

        int[] cnt = fastCountSegments(starts, ends, points);
        long sum = 0;
        for (int x : cnt) {
            sum+=x;
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}

