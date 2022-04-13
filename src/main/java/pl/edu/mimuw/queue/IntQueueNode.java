package pl.edu.mimuw.queue;

public class IntQueueNode {

  private final int value;
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

  public int value() {return this.value;}

  public IntQueueNode next() {return this.next;}

  public IntQueueNode prev() {return this.prev;}

  /**
   * Searches through {@code next} references until it encounters a node with
   * empty {@code next} reference (that is, the end of the queue). It then
   * extends that queue by adding a new end node.
   */
  public void attachToEnd(IntQueueNode newEnd) {
    if (this.next == null) this.next = newEnd;
    else this.prev.next = newEnd;
    this.prev = newEnd;
  }

  /**
   * Adds a bidirectional connection between a prev node and this node.
   */
  public void attachPrev(IntQueueNode prev) {
    this.prev = prev;
    prev.next = this;
  }
}
