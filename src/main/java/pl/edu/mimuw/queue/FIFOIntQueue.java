package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  /**
   * Adds element to the end of the queue
   */
  public void offer(Integer x) {
    if (x == null) {
      throw new NullPointerException();
    }

    var newElement = new IntQueueNode(x, null);

    if (this.end != null) {
      this.end.setNext(newElement);
    }
    else {
      this.start = newElement;
    }
    this.end = newElement;
    this.size++;
  }

  public String toString() {
    return "FIFO " + this.stringQueueRepresentation();
  }
}
