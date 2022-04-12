package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
  protected IntQueueNode back;

  public FIFOIntQueue() {
    super();
    this.back = null;
  }

  /**
   * Adds element to the end of the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException("specified element is null");

    IntQueueNode newQ = new IntQueueNode(x);
    if (this.size != 0) {
      this.back.SetNext(newQ);
    } else {
      this.front = newQ;
    }
    this.back = newQ;
    this.size++;
  }

  public Integer poll() {
    if (this.peek() == null) return null;

    this.size--;
    final int value = this.front.GetValue();
    this.front = this.front.GetNext();
    return value;
  }
}
