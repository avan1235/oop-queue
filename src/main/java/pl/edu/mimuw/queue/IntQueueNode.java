package pl.edu.mimuw.queue;

public class IntQueueNode {

  private final int value;
  public IntQueueNode next;
  public IntQueueNode prev;

  public IntQueueNode(int value, IntQueueNode next, IntQueueNode prev) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

  public IntQueueNode(int value) {
    this(value, null, null);
  }

  public int getValue() {
    return this.value;
  }
}
