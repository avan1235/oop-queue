package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
  private IntQueueNode tail;

  public FIFOIntQueue() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();

    final var newNode = new IntQueueNode(x);

    if (this.size == 0) {
      this.head = newNode;
    } else {
      this.tail.setNext(newNode);
    }

    this.tail = newNode;
    this.size++;
  }

  public Integer poll() {
    if (this.size == 0) {
      return null;
    } else {
      final IntQueueNode removedNone = this.head;

      this.head = removedNone.getNext();
      this.size--;

      return removedNone.getValue();
    }
  }

  public String toString() {
    final var sb = new StringBuilder();
    sb.append("FIFO Int Queue of size ").append(this.size).append(", elements: ");

    IntQueueNode curNode = this.head;
    while (curNode != null) {
      sb.append(curNode.getValue()).append(", ");
      curNode = curNode.getNext();
    }

    return sb.toString();
  }
}
