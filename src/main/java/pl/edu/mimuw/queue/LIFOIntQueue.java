package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {
  public void offer(Integer x) {
    this.push(x);
  }

  public Integer peek() {
    if (this.size == 0)
      return null;
    if (this.size == 1)
      return this.front.getValue();

    return this.back.getValue();
  }

  //pop_back
  public Integer poll() {
    this.size--;
    if (this.size < 0) {
      this.size = 0;
      return null;
    }
    if (this.size == 0) {
      int ans = this.front.getValue();
      this.front = null;
      return ans;
    }
    if (this.size == 1) {
      int ans = this.back.getValue();
      this.back = null;
      this.front = new IntQueueNode(this.front.getValue(), null, null);
      return ans;
    }
    int ans = this.back.getValue();

    this.back = this.back.getPrev();
    this.back.setNext(null);
    return ans;
  }
}
