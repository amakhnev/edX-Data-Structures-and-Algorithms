import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
      int [][] values = new int[s.length()+1][t.length()+1];
      for(int i=1;i<=s.length();i++){
          values[i][0] = i;
      }
      for(int i=1;i<=t.length();i++){
          values[0][i] = i;
      }

      for (int i=1;i<=s.length();i++){
          for (int j = 1; j<=t.length();j++){
              int minValue = values[i-1][j-1]+ ((s.charAt(i-1)==t.charAt(j-1))?0:1);

              if (values[i-1][j] + 1 < minValue){
                  minValue = values[i-1][j] + 1;
              }

              if (values[i][j-1] + 1 < minValue){
                  minValue = values[i][j-1] + 1;
              }

              values[i][j] = minValue;
          }
      }
      return values[s.length()][t.length()];
  }
  public static void main(String args[]) throws FileNotFoundException {
    Scanner scan = new Scanner(new FileInputStream("C:\\Users\\User\\Downloads\\temp\\5_3_edit_distance.in"));

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
//          System.out.println(EditDistance("editing", "distance"));
  }

}
