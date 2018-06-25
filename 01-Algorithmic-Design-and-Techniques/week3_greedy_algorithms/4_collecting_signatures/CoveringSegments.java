import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here

        Arrays.sort(segments, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                if (o1.end > o2.end) return 1;
                if (o1.end < o2.end) return -1;
                if (o1.start > o2.start) return 1;
                if (o1.start < o2.start) return -1;
                return 0;
            }
        });

        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < segments.length; ) {
            int currentPoint = segments[i].end;
            points.add(currentPoint);
            while (i < segments.length && segments[i].start <= currentPoint) {
                i++;
            }

        }
        int[] result = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            result[i] = points.get(i);
        }
        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
