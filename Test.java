
public class Test {

  public static void main (String[] args) {
    int[] corgie = {1,2,3,4,5,466,6,7,8,9};
    // print(corgie);
    StdOut.print(4);
  }

  public static int max (int[] arr) {
    return max_helper(arr, 1, arr[0]);
  }

  private static int max_helper (int[] arr, int idx, int max) {
    if (idx >= arr.length) {
      return max;
    }
    if (arr[idx] > max) {
      max = arr[idx];
    }
    return max_helper(arr, idx + 1, max);
  }

  public static void print (int[] arr) {
    String print = "[" + arr[0];
    for (int i = 1; i < arr.length; i ++) {
      print +=  ", " + arr[i];
    }
    print += "]";
    System.out.println(print);
  }

  public static double average (int[] arr) {
    double total = 0;
    for (int i = 0; i < arr.length; i ++) {
      total += arr[i];
    }
    return total / arr.length;
  }

  public static int[] reverse (int[] arr) {
    int[] new_arr = new int[arr.length];
    for (int i = 0; i < arr.length; i ++) {
      new_arr[i] = arr[arr.length - 1 - i];
    }
    return new_arr;
  }

}
