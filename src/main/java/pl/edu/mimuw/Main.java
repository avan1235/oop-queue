package pl.edu.mimuw;

import pl.edu.mimuw.queue.FIFOIntQueue;

public class Main {

  public static void main(String[] args) {
    FIFOIntQueue x = new FIFOIntQueue();
    x.offer(2);
    x.offer(1);
    x.offer(3);
    x.offer(7);
    System.out.println(x.toString());
    
  }
}
