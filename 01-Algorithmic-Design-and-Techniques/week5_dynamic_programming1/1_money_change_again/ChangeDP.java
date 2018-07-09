import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {

        int [] values = new int[m+1];
        values[1]=1;values[2]=2;
        values[3]=1;values[4]=1;

        for (int i=5;i<=m;i++){
            values[i] = Math.min(values[i-4]+1,Math.min(values[i-1]+1,values[i-3]+1));
        }

        return values[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

