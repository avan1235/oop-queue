package pl.edu.mimuw.queue;

public class IntQueueNode {

  private final int value;
  private final IntQueueNode next;
  private final IntQueueNode prev;

  public IntQueueNode(int value, IntQueueNode next, IntQueueNode prev) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

  public int getValue() {
    return this.value;
  }

  public IntQueueNode getNext() {
    if (next == null) return null;
    return new IntQueueNode(next.getValue());
  }

  public IntQueueNode getPrev() {
    if (prev == null) return null;
    return new IntQueueNode(prev.getValue());
  }

  public IntQueueNode(int value) {
    this(value, null, null);
  }
}
