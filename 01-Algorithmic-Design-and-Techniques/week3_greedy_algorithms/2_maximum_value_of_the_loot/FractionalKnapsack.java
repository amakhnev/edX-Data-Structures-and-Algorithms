import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        Item[] items = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item p1, Item p2) {
                if (p1.price > p2.price) return -1;
                if (p1.price < p2.price) return 1;
                return 0;
            }
        });

        int result = 0, capacityLeft = capacity;

        for (int i = 0; i < items.length && capacityLeft > 0; i++) {
            if (capacityLeft > items[i].weight) {
                result += items[i].value;
                capacityLeft -= items[i].weight;
            } else {
                result += items[i].price * capacityLeft;
                capacityLeft = 0;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

    private static class Item {
        int value, weight;
        double price;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.price = (double) value / weight;
        }
    }
} 
