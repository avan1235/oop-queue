package pl.edu.mimuw.queue;

import java.util.ArrayList;

public class LIFOIntQueue extends AbstractIntQueue {
  public LIFOIntQueue() {
    this.head = null;
    this.size = 0;
  }

  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();

    final var newNode = new IntQueueNode(x);

    newNode.setNext(this.head);
    this.head = newNode;
    this.size++;
  }

  public Integer poll() {
    if (this.head == null) return null;

    final var removedNode = this.head;
    this.head = removedNode.getNext();
    this.size--;

    return removedNode.getValue();
  }

  public String toString() {
    final var sb = new StringBuilder();
    sb.append("LIFO Int Queue of size ").append(this.size).append(", elements: ");

    var curNode = this.head;
    while (curNode != null) {
      sb.append(curNode.getValue()).append(", ");
      curNode = curNode.getNext();
    }

    return sb.toString();
  }
}
