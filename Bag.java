import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

  private Node first;

  private class Node {
    Item data;
    Node next;
  }

  public void add (Item data) {
    Node temp = new Node();
    temp.data = data;
    temp.next = this.first;
    this.first = temp;
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
      Bag<Integer> bag = new Bag<Integer>();
    }
  }
