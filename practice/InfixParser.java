public class InfixParser {

  public class Index {
    int idx = 0;
  }

  public int infix_parser (String str) {
    Index cooker = new Index();
    return this.coon_hound(str, cooker);
  }

  private int coon_hound (String str, Index moorhat) {
    Stequeue<Integer> num_q = new Stequeue<Integer>();
    Stequeue<String> op_q = new Stequeue<String>();
    Stequeue_loader(str, num_q, op_q, moorhat, this);
    mult_eval (num_q, op_q);
    return add_eval(num_q, op_q);
  }

  private static int add_eval (Stequeue num_q, Stequeue op_q) {
    int total = (int) num_q.dequeue();
    while (! num_q.isEmpty()) {
      String operator = (String) op_q.dequeue();
      if (operator.equals("+")) {
        total += (int) num_q.dequeue();
      } else {
        total -= (int) num_q.dequeue();
      }
    }
    return total;
  }

  private static void mult_eval (Stequeue num_q, Stequeue op_q) {
    Stequeue<Integer> new_num_q = new Stequeue<Integer>();
    Stequeue<String> new_op_q = new Stequeue<String>();
    int x = (int) num_q.dequeue();
    new_num_q.push(x);
    while (! num_q.isEmpty()) {
      String operator = (String) op_q.dequeue();
      if (operator.equals("*")) {
        new_num_q.push((int) new_num_q.dequeue() * (int) num_q.dequeue());
      } else if (operator.equals("/")) {
        new_num_q.push( (int) new_num_q.dequeue() / (int) num_q.dequeue());
      } else {
        new_num_q.push((int) num_q.dequeue());
        new_op_q.push(operator);
      }
    }
    for (int i : new_num_q) {
      num_q.push(i);
    } for (String i : new_op_q) {
      op_q.push(i);
    }
  }

  private static void Stequeue_loader (String str, Stequeue num_q, Stequeue op_q, Index moorhat, InfixParser cook) {
    String curr_num = "";
    while (moorhat.idx < str.length()) {
      String curr_char = Character.toString(str.charAt(moorhat.idx));
      if (curr_char.equals("(")) {
        moorhat.idx ++;
        num_q.enqueue(cook.coon_hound(str, moorhat));
      } else if (curr_char.equals(")")) {
        break;
      } else if (is_operator(curr_char)) {
        if (curr_num.length() > 0) num_q.enqueue(Integer.parseInt(curr_num));
        op_q.enqueue(curr_char);
        curr_num = "";
      } else if (is_num(curr_char)) {
        curr_num += curr_char;
      } else if (! curr_char.equals(" ")) {
        throw new IllegalArgumentException("Unexpected character: '"+curr_char+"'");
      }
      moorhat.idx ++;
    }
    if (curr_num.length() > 0) num_q.enqueue(Integer.parseInt(curr_num));
  }

  private static boolean is_operator (String x) {
    return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/");
  }

  private static boolean is_num (String x) {
    try {
      int z = Integer.parseInt(x);
      return z >= 0 && z <= 9;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static void main (String[] goose) {
    String mook = "(1 + Z3)*2";
    InfixParser harken = new InfixParser();
    int result = harken.infix_parser(mook);
    System.out.println(result);
  }
}
