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
    for (int i = 0; i < expectedSize; i++) queue.offer(i);

    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  // TODO: add more complex test for elements' order in queue

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
  void testAddElementsInOrderBig() {
    final var queue = new LIFOIntQueue();

    for(int i = 0; i < 100; i++) {
      queue.offer(2 * i);
      queue.offer(2 * i + 1);

      var popped = queue.poll();
      assertEquals(2 * i + 1, popped);
    }

    assertEquals(100, queue.size());

    int expectedPopped = 198;
    while(queue.size() != 0) {
      var popped = queue.poll();
      assertEquals(expectedPopped, popped);
      expectedPopped -= 2;
    }
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
