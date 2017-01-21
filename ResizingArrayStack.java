import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

  private Item[] memory;
  private int idx;

  public ResizingArrayStack () {
    this.memory = (Item[]) new Object[1];
    this.idx = 0;
  }

  public void push (Item data) {
    if (this.isFull()) {
      this.resize(this.memory.length * 2);
    }
    this.memory[this.idx ++] = data;
  }

  public Item pop () {
    if (this.idx !=0) {
      Item temp = this.memory[-- this.idx];
      this.memory[this.idx] = null;
      if (this.idx <= this.memory.length / 4) {
        this.resize(this.memory.length / 2);
      }
      return temp;
    }
    return null;
  }

  private void resize (int new_size) {
    Item[] temp = (Item[]) new Object[new_size];
    for (int i = 0; i < this.idx; i ++) {
      temp[i] = this.memory[i];
    }
    this.memory = temp;
  }

  public boolean isEmpty () {
    return this.idx == 0;
  }

  private boolean isFull () {
    return this.idx >= this.memory.length;
  }

  // Iterator stuff - %^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^
  public Iterator<Item> iterator () {
    return new ArrayIterator();
  }
  public class ArrayIterator implements Iterator<Item> {
    private int index = idx - 1;
    public boolean hasNext () { return index >= 0;       }
    public Item next ()       { return memory[index --]; }
    public void remove ()     {                          }
  }
  // %^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^%^

  public static void main (String[] rookie_of_the_year) {
    ResizingArrayStack<Integer> stacker = new ResizingArrayStack<Integer>();
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
  }
}
