package pl.edu.mimuw.queue;

public class IntQueueNode {

  private final Integer value;
  private IntQueueNode next;
  private IntQueueNode prev;

  public IntQueueNode(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public IntQueueNode getNext() {
    return next;
  }

  public IntQueueNode setNext(IntQueueNode next) {
    return this.next = next;
  }

  public IntQueueNode getPrev() {
    return prev;
  }

  public IntQueueNode setPrev(IntQueueNode prev) {
    return this.prev = prev;
  }
}
