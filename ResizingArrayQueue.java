import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Iterable<Item> {

  private Item[] memory = (Item[]) new Object[1];
  private int front = 0;
  private int back = 0;
  private int size = 0;

  // if you are enqueing and front == back, you are full;
  // if you are dequeing and front == back, you are empty;


  public void enqueue (Item data) {
    this.memory[this.back ++] = data;
    if (this.back == this.memory.length) this.back = 0;
    this.size ++;
    if (this.back == this.front) this.resize(this.memory.length * 2);
  }

  public Item dequeue () {
    if (this.size > 0) {
      Item temp = this.memory[this.front ++];
      this.memory[this.front - 1] = null;
      if (this.front == this.memory.length) this.front = 0;
      this.size --;
      if (this.size == this.memory.length / 4) this.resize(this.memory.length / 2);
      return temp;
    }
    return null;
  }

  private void resize (int new_size) {
    Item[] temp = (Item[]) new Object[new_size];
    for (int i = 0; i < this.size; i ++) {
      temp[i] = this.memory[(this.front + i) % this.memory.length];
    }
    this.front = 0;
    this.back = this.size;
    this.memory = temp;
  }

  public boolean isEmpty () {
    return this.size == 0;
  }

  // Iterator stuff - %^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^
  public Iterator<Item> iterator () {
    return new ArrayIterator();
  }
  public class ArrayIterator implements Iterator<Item> {
    private int index = front;
    private int last = back == 0 ? memory.length - 1 : back;
    public boolean hasNext () {
      return index != last;
    }
    public Item next () {
      Item temp = memory[index ++];
      if (index == memory.length) index = 0;
      return temp;
    }
    public void remove ()     {                          }
  }
  // %^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^

  public static void main (String[] rookie_of_the_year) {
    ResizingArrayQueue<Integer> stacker = new ResizingArrayQueue<Integer>();
    for (int i = 0; i < 10; i ++) {
      stacker.enqueue(i);
    }
    for (int i : stacker) {
      System.out.println(i + ",");
    }
    for (int i = 0; i < 8; i ++) {
      stacker.dequeue();
    }
    for (int i : stacker) {
      System.out.println(i + ",");
    }
  }
}
