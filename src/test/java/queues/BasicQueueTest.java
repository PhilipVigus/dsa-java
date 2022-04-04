package queues;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicQueueTest {
  @Test
  @DisplayName("isEmpty returns true for a newly initialised queue")
  void isEmptyReturnsTrueForANewlyIntialisedQueueTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 1);

    assertTrue(queue.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns false for a queue containing elements")
  void isEmptyReturnsFalseForAQueueContainingElementsTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 1);

    queue.enQueue(1);

    assertFalse(queue.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns true after the last element in a queue has been dequeued")
  void isEmptyReturnsTrueAfterTheLastElementInAQueueHasBeenDequeuedTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 1);

    queue.enQueue(1);
    queue.deQueue();

    assertTrue(queue.isEmpty());
  }

  @Test
  @DisplayName("isFull returns true for a full queue")
  void isFullReturnsTrueForFullQueueTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 1);

    queue.enQueue(1);

    assertTrue(queue.isFull());
  }

  @Test
  @DisplayName("isFull returns false for a queue that is not full")
  void isFullReturnsFalseForAQueueThatIsNotFullTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 2);

    queue.enQueue(1);

    assertFalse(queue.isFull());
  }

  @Test
  @DisplayName("enQueue adds an element to the end of the queue")
  void enQueueAddsAnElementToTheEndOfTheQueueTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 2);

    queue.enQueue(1);
    queue.enQueue(2);

    assertEquals(1, queue.deQueue());
  }

  @Test
  @DisplayName("enQueuing to a full queue throws an IllegalStateException")
  void enQueuingToAFullQueueThrowsAnIllegalStateExceptionTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 1);

    queue.enQueue(1);

    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> queue.enQueue(2));
    assertEquals("Unable to enqueue element to full queue", exception.getMessage());
  }

  @Test
  @DisplayName("deQueue removes the element at the front of the queue")
  void deQueueRemovesTheElementAtTheFrontOfTheQueueTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 2);

    queue.enQueue(1);
    queue.enQueue(2);

    assertEquals(1, queue.deQueue());
  }

  @Test
  @DisplayName("deQueuing from an empty queue throws an IllegalStateException")
  void deQueuingFromAnEmptyQueueThrowsAnIllegalStateExceptionTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 1);

    IllegalStateException exception = assertThrows(IllegalStateException.class, queue::deQueue);
    assertEquals("Unable to dequeue element from empty queue", exception.getMessage());
  }

  @Test
  @DisplayName("toString returns a string representation of the queue")
  void toStringTest() {
    BasicQueue<Integer> queue = new BasicQueue<>(Integer.class, 5);

    queue.enQueue(1);
    queue.enQueue(2);

    assertEquals("BasicQueue{[1, 2, null, null, null]}", queue.toString());
  }
}
