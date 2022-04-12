package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
  private IntQueueNode end;

  FIFOIntQueue() {
    end = null;
  }

  /**
   * Adds element to the end of queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  @Override
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();
    if (end == null)
      begin = end = new IntQueueNode(x);
    else {
      IntQueueNode node = new IntQueueNode(x, null, end);
      end.next = node;
      end = node;
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
