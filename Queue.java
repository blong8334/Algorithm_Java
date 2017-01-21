import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  // Enqueue from the back, dequeue from the front.

  private Node first;
  private Node last;
  private int size = 0;

  private class Node {
    Item data;
    Node next;
  }

  public void enqueue (Item data) {
    Node temp = new Node();
    temp.data = data;
    if (this.size == 0) {
      this.first = temp;
    } else {
      this.last.next = temp;
    }
    this.last = temp;
    this.size ++;
  }

  public Item dequeue () {
    if (this.size > 0) {
      Item temp = this.first.data;
      this.first = this.first.next;
      this.size --;
      if (this.size == 0) {
        this.last = null;
      }
      return temp;
    }
    return null;
  }

  public boolean isEmpty () {
    return this.size == 0;
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
    public boolean hasNext () {
      return curr != null;
    }
    public Item next () {
      Item temp = curr.data;
      curr = curr.next;
      return temp;
    }
    public void remove () {
    }
  }
  // %^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^

  public static void main (String[] rookie_of_the_year) {
    Queue<Integer> queue_t_pi = new Queue<Integer>();
    for (int i = 0; i < 10; i ++) {
      queue_t_pi.enqueue(i);
    }
    for (int i : queue_t_pi) {
      System.out.println(i + ",");
    }
    queue_t_pi.enqueue(2);
    for (int i : queue_t_pi) {
      System.out.println(i + ",");
    }
    queue_t_pi.dequeue();
    for (int i : queue_t_pi) {
      System.out.println(i + ",");
    }
  }
}
