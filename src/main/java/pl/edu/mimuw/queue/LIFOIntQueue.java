package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {
  /**
   * Adds element to begin of queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  @Override
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();
    if (begin == null)
      begin = new IntQueueNode(x);
    else {
      IntQueueNode node = new IntQueueNode(x, begin, null);
      begin.prev = node;
      begin = node;
    }
    size++;
  }

  @Override
  public Integer peek() {
    if (begin == null) return null;
    return begin.value;
  }

  @Override
  public Integer poll() {
    if (begin == null) return null;
    Integer res = begin.value;
    begin = begin.next;
    size--;
    return res;
  }
}
