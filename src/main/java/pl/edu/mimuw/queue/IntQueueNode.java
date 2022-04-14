package pl.edu.mimuw.queue;

public class IntQueueNode {

  private final int value;
  protected IntQueueNode next;
  protected IntQueueNode prev;

  public IntQueueNode(int value, IntQueueNode next, IntQueueNode prev) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

  public int getValue() {
    return this.value;
  }

  public IntQueueNode getNext() {
    //if (next == null) return null;
    return next;
  }

  public void setNext(IntQueueNode newNode) {
    this.next = newNode;
  }

  public IntQueueNode getPrev() {
    if (prev == null) return null;
    return prev;
  }

  public void setPrev(IntQueueNode newNode) {
    this.prev = newNode;
  }

  public IntQueueNode(int value) {
    this(value, null, null);
  }
}

