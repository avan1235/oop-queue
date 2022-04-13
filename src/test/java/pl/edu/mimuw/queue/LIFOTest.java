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
		for(int i = 0; i < expectedSize; i++) {
			queue.offer(i);
		}
		
		final var size = queue.size();
		
		assertEquals(expectedSize, size);
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
	
	@Test
	void moreComplexTest() {
		final var queue = new LIFOIntQueue();
		for(var x: new int[]{2, 1, 3, 7}) {
			queue.offer(x);
		}
		
		for(var x: new int[]{7, 3, 1, 2}) {
			assertEquals(queue.poll(), x);
		}
		assertEquals(queue.size(), 0);
		
		for(int i = 1; i <= 69; i++) {
			if(i % 3 == 0) {
				assertEquals(queue.poll(), i - 1);
				assertEquals(queue.peek(), i - 2);
				assertEquals(queue.size(), i / 3);
			}
			else {
				queue.offer(i);
				assertEquals(queue.size(), (i + 4) / 3);
			}
		}
	}
}
