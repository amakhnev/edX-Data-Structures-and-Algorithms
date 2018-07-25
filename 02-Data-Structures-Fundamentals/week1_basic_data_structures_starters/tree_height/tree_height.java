import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class Node {
        private List<Node> children = new ArrayList<>();

        public Node() {

        }

        public void addChild(Node child) {
            if (!children.contains(child)) {
                children.add(child);
            }
        }

        public List<Node> getChildren() {
            return children;
        }

    }

    public class TreeHeight {
        int n;
        int parent[];

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            Node root = null;
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
            }
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == -1) {
                    root = nodes[i];
                } else {
                    nodes[parent[i]].addChild(nodes[i]);
                }
            }
            int maxHeight = 0;
            Queue<Object[]> nodeQueue = new LinkedList<>();
            if (root != null) {
                nodeQueue.add(new Object[]{root, 1});
            }

            while (!nodeQueue.isEmpty()) {
                Object[] currentNode = nodeQueue.poll();
                int height = (int) currentNode[1];
                maxHeight = Math.max(maxHeight, height);
                for (Node child : ((Node) currentNode[0]).getChildren()) {
                    nodeQueue.add(new Object[]{child, height + 1});
                }
            }
            return maxHeight;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
