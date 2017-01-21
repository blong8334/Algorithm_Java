import java.util.Iterator;

public class Stequeue<Item> implements Iterable<Item> {
  // Enqueue from the front or back, dequeue from the front.

  private Node first;
  private Node last;
  private int size = 0;

  private class Node {
    Item data;
    Node next;
    Node previous;
  }

  public void push_to_back (Item data) {
    Node temp = new Node();
    temp.data = data;
    if (this.size == 0) {
      this.first = temp;
    } else {
      this.last.next = temp;
      temp.previous = this.last;
    }
    this.last = temp;
    this.size ++;
  }

  public void push_to_front (Item data) {
    Node temp = new Node();
    temp.data = data;
    if (this.size == 0) {
      this.last = temp;
    } else {
      temp.next = this.first;
      this.first.previous = temp;
    }
    this.first = temp;
    this.size ++;
  }

  public Item pop_from_front () {
    if (this.size > 0) {
      Item temp = this.first.data;
      this.first = this.first.next;
      this.size --;
      if (this.size == 0) {
        this.last = null;
      } else {
        this.first.previous = null;
      }
      return temp;
    }
    return null;
  }

  public Item pop_from_back () {
    if (this.size > 0) {
      Item temp = this.last.data;
      this.last = this.last.previous;
      this.size --;
      if (this.size == 0) {
        this.first = null;
      } else {
        this.last.next = null;
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
}
