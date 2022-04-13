package pl.edu.mimuw.queue;

/**
 * Adds element to the front of the queue
 */
public class LIFOIntQueue extends AbstractIntQueue {
  public void offer(Integer x) {
    if (x == null) {
      throw new NullPointerException();
    }

    this.start = new IntQueueNode(x, this.start);
    this.size++;
  }

  public String toString() {
    return "LIFO " + this.stringQueueRepresentation();
  }
}
