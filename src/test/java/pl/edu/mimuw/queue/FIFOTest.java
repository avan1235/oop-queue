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
  void testAddsIncreasesSize1() {
    final var queue = new FIFOIntQueue();

    final var expectedSize = 2;
    for (int i = 0; i < expectedSize; i++) queue.offer(i);

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

  //my own test including toString();
  @Test
  void myOwnTest() {
    final var queue = new FIFOIntQueue();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
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
  void mySecondTest() {
    final var queue = new FIFOIntQueue();
    for (int i = 1; i <= 20; i++)
      queue.offer(i);

    for (int i = 1; i <= 5; i++) {
      int head = queue.poll();
      assertEquals(head, i);
    }
    for (int i = 21; i <= 25; i++) {
      queue.offer(i);
    }
    for (int i = 6; i <= 25; i++) {
      int expected = i;
      int head = queue.poll();
      assertEquals(head, expected);
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
