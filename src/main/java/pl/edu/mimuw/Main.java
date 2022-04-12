package pl.edu.mimuw;

import pl.edu.mimuw.queue.FIFOIntQueue;
import pl.edu.mimuw.queue.LIFOIntQueue;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //Dodatkowy pseudo-test ze scannerem do ręcznego używania  w mainie (zamiast asercji po prostu drukuje na ekran bieżcy stan danych, poza tym do dopisanych do pliku z testami)
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    var s = new FIFOIntQueue();
    var q = new LIFOIntQueue();
    for (int i = 1; i < n; i++) {
      s.offer(i);
      q.offer(i);
    }
    System.out.println("Stack size=" + s.size());
    System.out.println("Queue size=" + q.size());
    System.out.println(s.peek());
    System.out.println(q.peek());
    System.out.println(s);
    System.out.println(q);

    for (int i = 0; i < n / 2; i++) {
      System.out.println("Polled: s:" + s.poll() + " q:" + q.poll());
    }

    System.out.println("Stack size=" + s.size());
    System.out.println("Queue size=" + q.size());

    while (!s.empty()) s.poll();
    while (!q.empty()) q.poll();
    System.out.println(s.empty() && q.empty());
    System.out.println("Stack size=" + s.size());
    System.out.println("Queue size=" + q.size());
    System.out.println(s);
    System.out.println(q);
    System.out.println(s.peek());
    System.out.println(q.peek());
  }
}
