package pl.edu.mimuw.queue;

import org.junit.jupiter.api.Test;

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
  void testElementsInOrder() {
    final var queue = new FIFOIntQueue();
    for (int i = 0; i < 100; i++)
      queue.offer(i);

    for (int expected = 0; expected < 50; expected++)
      assertEquals(expected, queue.poll());

    for (int i = 100; i < 500; i++)
      queue.offer(i);

    for (int expected = 50; expected < 500; expected++)
      assertEquals(expected, queue.poll());
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
}
