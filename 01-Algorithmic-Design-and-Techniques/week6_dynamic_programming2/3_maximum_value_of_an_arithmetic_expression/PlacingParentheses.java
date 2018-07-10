import java.util.Scanner;

public class PlacingParentheses {

    private static long getMaximValue(String exp) {
        if (exp.startsWith("-")){
            exp = "0"+exp;
        }
        String [] splitStr = exp.split("[\\D]");
        long[] numbers = new long[splitStr.length];
        char[] operators = new char[splitStr.length-1];

        int currentIdx =0;
        for (int i=0;i<splitStr.length;i++){
            currentIdx+=splitStr[i].length();
            numbers[i] = Long.parseLong(splitStr[i]);
            if (i<splitStr.length-1){
                operators[i] = exp.charAt(currentIdx);
                currentIdx++;
            }
        }


        long [][][] matrix = new long[numbers.length][numbers.length][2];

        for (int offset = 0; offset<numbers.length;offset++){
            for (int i=0;i<numbers.length-offset;i++){

                if (offset == 0){
                    matrix[i][i][0] = numbers[i];
                    matrix[i][i][1] = numbers[i];
                } else{
                    long max = Long.MIN_VALUE,min = Long.MAX_VALUE;
                    for (int k = 0;k<offset;k++){
                        char operation = operators[i+k];
                        long val1 = eval(matrix[i][i+k][0],matrix[i+k+1][i+offset][0],operation);
                        long val2 = eval(matrix[i][i+k][0],matrix[i+k+1][i+offset][1],operation);
                        long val3 = eval(matrix[i][i+k][1],matrix[i+k+1][i+offset][0],operation);
                        long val4 = eval(matrix[i][i+k][1],matrix[i+k+1][i+offset][1],operation);

                        min = Math.min(min,Math.min(Math.min(val1,val2),Math.min(val3,val4)));
                        max = Math.max(max,Math.max(Math.max(val1,val2),Math.max(val3,val4)));
                    }
                    matrix[i][i+offset][0] = min;
                    matrix[i][i+offset][1] = max;
                }
            }
        }
        return matrix[0][numbers.length-1][1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
//        String exp = "7+6+3-2-7-4*2+4+2-9*6*8";
        System.out.println(getMaximValue(exp));
    }
}

