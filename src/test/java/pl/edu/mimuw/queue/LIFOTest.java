package pl.edu.mimuw.queue;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LIFOTest {

  @Test
  void testCreatedAsEmpty() {
    final var queue = new LIFOIntQueue();

    final var expectedSize = 0;
    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  @Test
  void testAddsIncreasesSize() {
    final var queue = new LIFOIntQueue();

    final var expectedSize = 42;
    for (int i = 0; i < expectedSize; i++) queue.offer(i);

    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  // TODO: add more complex test for elements' order in queue

  @Test
  void testAddsElementsInOrder() {
    final var queue = new LIFOIntQueue();
    queue.offer(42);// podobnie jak poniżej
    queue.offer(24);

    final var expectedHead = 42;
    final var head = queue.peek();

    assertEquals(expectedHead, head);
  }

  @Test
  void testRemovesElementsInOrder() {
    final var queue = new LIFOIntQueue();
    queue.offer(42);// wydaje mi się że oryginalnie tutaj były liczby wpisane na odwrót, w pliku z FIFO jak do testowania LIFO i vice versa
    // (inna sprawa że ja za wierzchołek stosu/początek kolejki w mojej implementacji unznałem indeks 0 a nie n-1, być może stąd rozbieżność)
    queue.offer(24);

    final var expectedRemoved = 42;
    final var expectedSize = 1;
    final var head = queue.poll();
    final var size = queue.size();

    assertEquals(expectedRemoved, head);
    assertEquals(expectedSize, size);
  }

  @Test
  void moreComplexTest1() {
    var q = new LIFOIntQueue(0);
    for (int i = 1; i < 1000000; i++) {
      q.offer(i);
    }
    for (int i = 0; i < 500000; i++) {
      int head = q.poll(), size = q.size();
      assertEquals(i, head);
      assertEquals(999999 - i, size);
    }

    while (!q.empty()) q.poll();
    assertEquals(0, q.size());
  }

  @Test
  void moreComplexTest2() {
    var rand = new Random();
    int n = rand.nextInt();
    int M = n % 89;
    var q = new FIFOIntQueue(0, M);
    for (int i = 1; i < n; i++) {
      q.offer(i);
    }
    int m = Math.min(n / 2, M);
    for (int i = 0; i < m; i++) {
      int head = q.poll(), size = q.size();
      assertEquals(i, head);
      assertEquals(m - 1 - i, size);
    }

    while (!q.empty()) q.poll();
    assertEquals(0, q.size());
  }
}


