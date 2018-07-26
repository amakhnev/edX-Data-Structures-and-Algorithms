import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];

        PriorityQueue<WorkerAvailability> workers = new PriorityQueue<>(numWorkers,new Comparator<WorkerAvailability>() {
                @Override
                public int compare(WorkerAvailability o1, WorkerAvailability o2) {
                    if (o1.nextAvailability!=o2.nextAvailability){
                        return Long.signum(o1.nextAvailability - o2.nextAvailability);
                    }
                    return o1.workerId-o2.workerId;
                }
            }
        );

        for (int i=0;i<numWorkers;i++){
            workers.add(new WorkerAvailability(i,0));
        }

        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            WorkerAvailability worker = workers.poll();

            assignedWorker[i] = worker.workerId;
            startTime[i] = worker.nextAvailability;
            worker.nextAvailability += duration;
            workers.add(worker);
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class WorkerAvailability{
        int workerId;
        long nextAvailability;

        public WorkerAvailability(int workerId, long nextAvailability) {
            this.workerId = workerId;
            this.nextAvailability = nextAvailability;
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
