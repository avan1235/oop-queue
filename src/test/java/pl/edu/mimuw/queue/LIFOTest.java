package pl.edu.mimuw.queue;

import org.junit.jupiter.api.Test;

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
    for (int i = 0; i < expectedSize; i++)
      queue.offer(i);

    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  @Test
  void testMoreComplexElementsOrder() {
    final var queue = new LIFOIntQueue();

    for (int i = 1; i <= 10; ++i)
      queue.offer(i);
    assertEquals(queue.size(), 10);
    for (int i = 10; i >= 1; --i)
      assertEquals(queue.poll(), i);
    assertEquals(queue.size(), 0);

    for (int i = 1; i <= 10; ++i) {
      queue.offer(i);
      queue.offer(100 + i);
      assertEquals(queue.poll(), 100 + i);
    }
    assertEquals(queue.size(), 10);
    for (int i = 10; i >= 1; --i)
      assertEquals(queue.poll(), i);
    assertEquals(queue.size(), 0);
  }

  @Test
  void testAddsElementsInOrder() {
    final var queue = new LIFOIntQueue();
    queue.offer(24);
    queue.offer(42);

    final var expectedHead = 42;
    final var head = queue.peek();

    assertEquals(expectedHead, head);
  }

  @Test
  void testRemovesElementsInOrder() {
    final var queue = new LIFOIntQueue();
    queue.offer(24);
    queue.offer(42);

    final var expectedRemoved = 42;
    final var expectedSize = 1;
    final var head = queue.poll();
    final var size = queue.size();

    assertEquals(expectedRemoved, head);
    assertEquals(expectedSize, size);
  }
}
