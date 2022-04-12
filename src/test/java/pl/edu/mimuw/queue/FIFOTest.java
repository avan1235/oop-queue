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
  void testAddsElementsInBulk() {
    final var queue = new FIFOIntQueue();

    final var Size = 42;
    for (int i = 0; i < Size; i++) queue.offer(i);
    for (int i = Size; i > 0; i--) queue.offer(i);

    for (int i = 0; i < Size; i++) {
      final var element = queue.poll();
      assertEquals(i, element);
    }
    for (int i = Size; i > 0; i--) {
      final var element = queue.poll();
      assertEquals(i, element);
    }
  }

  @Test
  void testToStringMethod() {
    final var queue = new FIFOIntQueue();

    final var Size = 42;
    for (int i = 0; i < Size; i++) queue.offer(i);
    for (int i = Size; i > 0; i--) queue.offer(i);

    assertEquals(queue.toString(),"queue: [ 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 ]");

    for (int i = 0; i < Size; i++) {
      final var element = queue.poll();
      assertEquals(i, element);
    }
    for (int i = Size; i > 0; i--) {
      final var element = queue.poll();
      assertEquals(i, element);
    }
  }
}


