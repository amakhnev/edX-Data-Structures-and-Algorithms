import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point point) {
            return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(int[] x, int y[]) {

        Point[] points = new Point[x.length];
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
            minX = Math.min(minX, x[i]);
            maxX = Math.max(maxX, x[i]);
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x == o2.x ? Long.signum(o1.y - o2.y) : Long.signum(o1.x - o2.x);
            }
        });


        return getMinimalDistance(points, minX, maxX + 1);
    }

    private static Double getMinimalDistance(Point[] points, int left, int right) {

        Double ans = Double.POSITIVE_INFINITY;

        if (points.length <= 1) {
            return Double.POSITIVE_INFINITY;
        }

        Point[] midPoints;

        if (left < right - 1) { // divide and conquer
            int mid = (left + right) / 2;
            ArrayList<Point> leftPoints = new ArrayList<>();
            ArrayList<Point> rightPoints = new ArrayList<>();
            for (Point point : points) {
                if (point.x < mid) {
                    leftPoints.add(point);
                } else {
                    rightPoints.add(point);
                }
            }
            ans = Math.min(getMinimalDistance(leftPoints.toArray(new Point[]{}), left, mid), getMinimalDistance(rightPoints.toArray(new Point[]{}), mid, right));
            if (ans != Double.POSITIVE_INFINITY) {
                ArrayList<Point> midPointsArr = new ArrayList<>();
                left = Math.max(left, mid - ans.intValue());
                right = Math.min(right, mid + ans.intValue());
                for (Point point : points) {
                    if (point.x > left && point.x < right) {
                        midPointsArr.add(point);
                    }
                }
                midPoints = midPointsArr.toArray(new Point[]{});
            } else {
                midPoints = points;
            }

        } else {
            midPoints = points;
        }


        Arrays.sort(midPoints);

        for (int i = 0; i < midPoints.length - 1; i++) {
            for (int j = i + 1; j < Math.min(midPoints.length, i + 8); j++) {
                ans = Math.min(ans, midPoints[i].distanceTo(midPoints[j]));
            }
        }

        return ans;
    }


    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\4_6_closest.in")));
//        reader = new BufferedReader(new InputStreamReader(System.in));

        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
