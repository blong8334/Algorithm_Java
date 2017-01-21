import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

  private Node first;
  private int size = 0;

  private class Node {
    Item data;
    Node next;
  }

  public void push (Item data) {
    Node temp = new Node();
    temp.data = data;
    temp.next = this.first;
    this.first = temp;
    this.size ++;
  }
  public Item peek () {
    if (this.first != null) {
      return this.first.data;
    }
    return null;
  }

  public Item pop () {
    if (this.first != null) {
      Item temp = this.first.data;
      this.first = this.first.next;
      this.size --;
      return temp;
    }
    return null;
  }

  public boolean isEmpty () {
    return this.first == null;
  }

  public int size () {
    return this.size;
  }

  // Iterator stuff - %^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^
  public Iterator<Item> iterator () {
    return new LLIterator();
  }
  public class LLIterator implements Iterator<Item> {
    private Node curr = first;
    public boolean hasNext ()  {
      return curr != null;
    }
    public Item next () {
      Item temp = curr.data;
      curr = curr.next;
      return temp;
    }
    public void remove () {}
    }
    // %^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^

    public static void main (String[] rookie_of_the_year) {
      Stack<Integer> stacker = new Stack<Integer>();
      for (int i = 0; i < 10; i ++) {
        stacker.push(i);
      }
      for (int i : stacker) {
        System.out.println(i + ",");
      }
      stacker.push(2);
      for (int i : stacker) {
        System.out.println(i + ",");
      }
      for (int i = 0; i < 80; i ++) {
        stacker.pop();
      }
    }
  }
