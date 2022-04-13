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

  //My test
  @Test
  void myOwnTest() {
    final var queue = new LIFOIntQueue();
    queue.offer(4);
    queue.offer(3);
    queue.offer(2);
    queue.offer(1);
    System.out.println(queue.toString());

    var peek1 = queue.peek();
    assertEquals(peek1, 1);
    var poll1 = queue.poll();
    assertEquals(poll1, 1);
    var peek2 = queue.peek();
    assertEquals(peek2, 2);

    var poll2 = queue.poll();
    assertEquals(poll2, 2);
    var poll3 = queue.poll();
    assertEquals(poll3, 3);
    var poll4 = queue.poll();
    assertEquals(poll4, 4);
    var poll5 = queue.poll();
    assertEquals(poll5, null);
  }

  @Test
  void anotherMy() {
    final var queue = new LIFOIntQueue();
    for (int i = 1; i <= 20; i++) {
      queue.offer(i);
    }
    System.out.println(queue.toString());
    for (int i = 1; i <= 10; i++) {
      int head = queue.poll();
      assertEquals(head, 20 + (1 - i));
      int size = queue.size();
      assertEquals(size, 20 - i);
    }

    System.out.println(queue.toString());
    for (int i = 21; i <= 30; i++)
      queue.offer(i);
    for (int i = 30; i >= 11; i--) {
      int head = queue.poll();
      int expected = i;
      if (i <= 20)
        expected -= 10;
      assertEquals(head, expected);
      int size = queue.size();
      assertEquals(size, 20 - (30 - i) - 1);
    }

    System.out.println(queue.toString());
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
