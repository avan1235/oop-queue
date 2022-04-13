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
  void testAddsAndPops() {
    final var queue = new FIFOIntQueue();
    int[] numbers = {1,6,3,7,3};
    int[] last3Numbers = {3,7,3};

    for (int i = 0; i < 3; i++) {
      queue.offer(numbers[i]);
    }
    assertEquals(queue.poll(), 1);
    for (int i = 3; i < 5; i++) {
      queue.offer(numbers[i]);
    }
    assertEquals(queue.poll(), 6);
    for (int i = 0; i < 3; i++) {
      var elem = queue.poll();
      assertEquals(last3Numbers[i], elem);
    }
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
