package pl.edu.mimuw.queue;

public class IntQueueNode {
  public final int value;
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
}
