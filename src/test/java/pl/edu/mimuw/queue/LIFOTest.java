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

  @Test
  void testAddsAndPops() {
    final var queue = new LIFOIntQueue();
    int[] numbers = {1,6,3,7,3};
    int[] numbersWithout3 = {1,6,7};

    for (int i = 0; i < 3; i++) {
      queue.offer(numbers[i]);
    }
    assertEquals(queue.poll(), 3);
    for (int i = 3; i < 5; i++) {
      queue.offer(numbers[i]);
    }
    assertEquals(queue.poll(), 3);
    for (int i = 0; i < 3; i++) {
      var elem = queue.poll();
      assertEquals(numbersWithout3[2 - i], elem);
    }
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
