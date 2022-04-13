package pl.edu.mimuw.queue;

public class IntQueueNode {

  private final int value;
  private IntQueueNode next;

  public IntQueueNode(int value, IntQueueNode next) {
    this.value = value;
    this.next = next;
  }


  public IntQueueNode(int value) {
    this(value, null);
  }

  public int GetValue (){
    return this.value;
  }

  public IntQueueNode GetNext(){
    return this.next;
  }

  public void SetNext(IntQueueNode next){
    this.next = next;
  }
}
