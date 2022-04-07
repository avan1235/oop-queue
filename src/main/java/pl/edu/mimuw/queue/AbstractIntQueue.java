package pl.edu.mimuw.queue;

import java.util.StringJoiner;

public abstract class AbstractIntQueue {

  private int length;

  // The head is to the right; the tail is to the left.
  private IntQueueNode leftmost, rightmost;

  protected void addRight(Integer value) {
    ++length;
    final var newNode = new IntQueueNode(value);
    if (leftmost == null && rightmost == null) {
      leftmost = rightmost = newNode;
      return;
    }
    newNode.setPrev(rightmost);
    rightmost.setNext(newNode);
    rightmost = newNode;
  }

  protected Integer peekLeft() {
    return leftmost == null ? null : leftmost.getValue();
  }

  protected Integer peekRight() {
    return rightmost == null ? null : rightmost.getValue();
  }

  protected Integer pollLeft() {
    if (leftmost == null && rightmost == null)
      return null;
    --length;
    final var oldNode = leftmost;
    if (leftmost == rightmost) {
      leftmost = rightmost = null;
    } else {
      leftmost = oldNode.getNext();
      leftmost.setPrev(null);
    }
    return oldNode.getValue();
  }

  protected Integer pollRight() {
    if (leftmost == null && rightmost == null)
      return null;
    --length;
    final var oldNode = rightmost;
    if (leftmost == rightmost) {
      leftmost = rightmost = null;
    } else {
      rightmost = oldNode.getPrev();
      rightmost.setNext(null);
    }
    return oldNode.getValue();
  }

  /**
   * Adds element to the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public void offer(Integer x) {
    if (x == null)
      throw new NullPointerException();
    addRight(x);
  }

  /**
   * @return the head of this queue, or {@code null} if this queue is empty,
   *         don't remove the element from the queue
   */
  public abstract Integer peek();

  /**
   * @return the head of this queue, or {@code null} if this queue is empty,
   *         and remove the element from the queue
   */
  public abstract Integer poll();

  /**
   * @return readable representation of ordered queue elements
   */
  @Override
  public String toString() {
    var joiner = new StringJoiner(", ", "[", "]");
    for (var i = leftmost; i != null; i = i.getNext()) {
      joiner.add(String.valueOf(i.getValue()));
    }
    return joiner.toString();
  }

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    return length;
  }
}
