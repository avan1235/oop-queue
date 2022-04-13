package pl.edu.mimuw.queue;

public class IntQueueNode {

  private final int value;
  private IntQueueNode next;

  public IntQueueNode(int value, IntQueueNode next) {
    this.value = value;
    this.next = next;
  }

  public IntQueueNode(int value) {
    this(value, null);
  }

  public int getValue() {
    return value;
  }

  public IntQueueNode getNext() {
    return next;
  }

  public void setNext(IntQueueNode nextNode) {
    this.next = nextNode;
  }
}
