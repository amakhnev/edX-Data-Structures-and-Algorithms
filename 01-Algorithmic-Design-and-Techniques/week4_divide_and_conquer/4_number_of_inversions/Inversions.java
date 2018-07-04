import java.io.FileInputStream;
import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        numberOfInversions += merge(a,b,left,ave,right);

        return numberOfInversions;
    }

    /**
     * assume array a contains two sorted subarrays from left to ave-1 and ave to right.
     * this procedure will merge two subarrays into temp array b and then assign back to a,
     * so it's sorted from left to right. in addition it will calculate number of pairs (x, y)
     * such that x ∈ a[left,ave-1], y ∈ a[ave,right], and x > y
     *
     */
    private static long merge(int[] a, int[] b, int left, int ave, int right) {
        long numberOfInversions = 0;
        int idxLeft = left,idxRight = ave, currentIdx=left;


        while (idxLeft<ave && idxRight<right){

            if (a[idxLeft]>a[idxRight]){
                numberOfInversions += ave-idxLeft;
                b[currentIdx++]=a[idxRight++];
            }else{
                b[currentIdx++]=a[idxLeft++];
            }
        }
        while (idxLeft<ave){
            b[currentIdx++]=a[idxLeft++];
        }
        while (idxRight<right){
            b[currentIdx++]=a[idxRight++];
        }

        //assign b back to a
        for (int i=left;i<right;i++){
            a[i]=b[i];
        }

        return numberOfInversions;
    }

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\4_4_inversions.in"));


//        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

