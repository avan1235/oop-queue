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
  public void pushLeft(int value) {
    this.prev = new IntQueueNode(value);
  }
  public void pushLeft(IntQueueNode n) {
    this.prev = n;
  }
  public void pushRight(int value) {
    this.next = new IntQueueNode(value);
  }
  public void pushRight(IntQueueNode n) {
    this.next = n;
  }
  public int getValue() {
    return this.value;
  }
  public IntQueueNode getNext() {
    return this.next;
  }
  public IntQueueNode getPrev() {
    return this.prev;
  }
  public void setPrev(IntQueueNode n) {
    this.prev = n;
  }
  public void setNext(IntQueueNode n) {
    this.next = n;
  }
}
