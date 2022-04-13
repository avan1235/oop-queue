package pl.edu.mimuw.queue;

public class IntQueueNode {

  private int value;
  private IntQueueNode next;
  private IntQueueNode prev;


  public IntQueueNode(int value, IntQueueNode next, IntQueueNode prev) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

  public IntQueueNode(int value) {
    this(value, null, null);
  }

  public IntQueueNode getPrev() {

    return this.prev;
  }

  public IntQueueNode getNext() {
    return this.next;
  }

  public int getValue() {
    return this.value;
  }

  public void setNext(IntQueueNode toSet) {
    this.next = toSet;
  }

  public void setPrev(IntQueueNode toSet) {
    this.prev = toSet;
  }

}
