// import edu.princeton.cs.algs4.StdOut;
// javac -cp '.:algs4.jar' Ch_1_1.java
// java -cp '.:algs4.jar' Ch_1_1

public class Ch_1_1 {

  public static void main (String[] args) {
    // three(args, 1);
    five(0.4, 0.1);
    // int x = lg_14(5094567);
    // int[] test = {1,2,3,4,3,7,8,5,0};
    // Test.print(histogram_15(test, 9));
    // _30(30);
  }

  public static void _30 (int n) {
    boolean[][] arr = new boolean[n][n];
    for (int i = 0; i < n; i ++) {
      for (int j = 0; j < n; j ++) {
        arr[i][j] = GCD_Bool(i, j);
        String out = i + ", " + j +", "+arr[i][j];
        System.out.println(out);
      }
    }
  }

  private static boolean GCD_Bool (int n, int k) {
    if (n < 1 || k < 1 || GCD(n, k) <= 1) {
      return true;
    }
    return false;
  }

  public static int GCD (int n, int k) {
    boolean negs = n < 1 || k < 1 ? true : false;
    if (negs) {
      throw new IllegalArgumentException("Arguments cannot be less than 1");
    }
    int num   = n > k ? n : k;
    int denom = n > k ? k : n;
    if (num % denom == 0) {
      return denom;
    }
    return GCD(denom, num % denom);
  }

  public static int[] histogram_15 (int[] a, int m) {
    int[] x_arr = new int[m];
    for (int i = 0; i < a.length; i ++) {
      x_arr[a[i]] ++;
    }
    return x_arr;
  }

  public static int lg_14 (int n) {
    return lg_helper_14(n, 0);
  }
  private static int lg_helper_14 (double n, int count) {
    if (n <= 2) {
      return count;
    }
    return lg_helper_14(n / 2, ++ count);
  }

  public static void five (double one, double two) {
    boolean one_1 = one < 1 && one > 0;
    boolean two_2 = two < 1 && two > 0;
    if (one_1 && two_2) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }

  public static void three (String[] args, int index) {
    if (index >= args.length) {
      System.out.println("True");
    } else if (Integer.parseInt(args[index]) != Integer.parseInt(args[index - 1])) {
      System.out.println("False");
    } else {
      three(args, index + 1);
    }
  }

}
