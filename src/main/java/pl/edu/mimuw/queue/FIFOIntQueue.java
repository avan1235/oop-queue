package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
  public void offer(Integer x) {
    this.push(x);
  }

  public Integer peek() {
    if (this.size == 0)
      return null;
    return this.front.getValue();
  }

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


    int ans = this.front.getValue();

    this.front = this.front.getNext();
    this.front.setPrev(null);

    if (this.size == 1)
      this.back = null;

    return ans;
  }
}
