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

  public IntQueueNode(int value) {
    this(value, null, null);
  }

  // TODO: make changes with this class fields, constructors, methods -
  //  this is just a helper class for your implementation that can be modified as you wish
}
