package pl.edu.mimuw.queue;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FIFOTest {

  @Test
  void testCreatedAsEmpty() {
    final var queue = new FIFOIntQueue();

    final var expectedSize = 0;
    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  @Test
  void testAddsIncreasesSize() {
    final var queue = new FIFOIntQueue();

    final var expectedSize = 42;
    for (int i = 0; i < expectedSize; i++) queue.offer(i);

    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  @Test
  void testAddsElementsInOrder() {
    final var queue = new FIFOIntQueue();
    queue.offer(42);
    queue.offer(24);

    final var expectedHead = 42;
    final var head = queue.peek();

    assertEquals(expectedHead, head);
  }

  @Test
  void testRemovesElementsInOrder() {
    final var queue = new FIFOIntQueue();
    queue.offer(42);
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
    var q = new FIFOIntQueue(0);
    for (int i = 0; i < 100; i++) {
      q.offer(i);
    }
    for (int i = 0; i < 50; i++) {
      int head = q.poll(), size = q.size();
      assertEquals(i, head);
      assertEquals(99 - i, size);
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
    for (int i = 0; i < n; i++) {
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

  @Test
  void moreComplexTest3() {//dodatkowy test z trochę ciekawszym doborem M
    var rand = new Random();
    int n = rand.nextInt();
    int M = ((n % 17) * (n % 1000000007)) % 89;
    var q = new FIFOIntQueue(0, M);
    for (int i = 0; i < n; i++) {
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


