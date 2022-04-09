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

  public void setNext(IntQueueNode newNode) {
    if (this.next == null) {
      this.next = newNode;
    }
  }

  public Integer getValue() {
    return this.value;
  }

  public IntQueueNode getNext() {
    return this.next;
  }
}
