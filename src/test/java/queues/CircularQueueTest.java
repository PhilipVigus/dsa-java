package queues;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CircularQueue Test")
class CircularQueueTest {
  @Test
  @DisplayName("isEmpty returns true for a newly initialised queue")
  void isEmptyReturnsTrueForANewlyIntialisedQueueTest() {
    CircularQueue queue = new CircularQueue(1);

    assertTrue(queue.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns false for a queue containing elements")
  void isEmptyReturnsFalseForAQueueContainingElementsTest() {
    CircularQueue queue = new CircularQueue(1);

    queue.enQueue(1);

    assertFalse(queue.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns true after the last element in a queue has been dequeued")
  void isEmptyReturnsTrueAfterTheLastElementInAQueueHasBeenDequeuedTest() {
    CircularQueue queue = new CircularQueue(1);

    queue.enQueue(1);
    queue.deQueue();

    assertTrue(queue.isEmpty());
  }

  @Test
  @DisplayName("isFull returns true for a full queue")
  void isFullReturnsTrueForFullQueueTest() {
    CircularQueue queue = new CircularQueue(1);

    queue.enQueue(1);

    assertTrue(queue.isFull());
  }

  @Test
  @DisplayName("isFull returns false for a queue that is not full")
  void isFullReturnsFalseForAQueueThatIsNotFullTest() {
    CircularQueue queue = new CircularQueue(2);

    queue.enQueue(1);

    assertFalse(queue.isFull());
  }

  @Test
  @DisplayName("enQueue adds an element to the end of the queue")
  void enQueueAddsAnElementToTheEndOfTheQueueTest() {
    CircularQueue queue = new CircularQueue(2);

    queue.enQueue(1);
    queue.enQueue(2);

    assertEquals(1, queue.deQueue());
  }

  @Test
  @DisplayName("enQueuing to a full queue throws an IllegalStateException")
  void enQueuingToAFullQueueThrowsAnIllegalStateExceptionTest() {
    CircularQueue queue = new CircularQueue(1);

    queue.enQueue(1);

    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> queue.enQueue(2));
    assertEquals("Unable to enqueue element to full queue", exception.getMessage());
  }

  @Test
  @DisplayName("deQueue removes the element at the front of the queue")
  void deQueueRemovesTheElementAtTheFrontOfTheQueueTest() {
    CircularQueue queue = new CircularQueue(2);

    queue.enQueue(1);
    queue.enQueue(2);

    assertEquals(1, queue.deQueue());
  }

  @Test
  @DisplayName("deQueuing from an empty queue throws an IllegalStateException")
  void deQueuingFromAnEmptyQueueThrowsAnIllegalStateExceptionTest() {
    CircularQueue queue = new CircularQueue(2);

    IllegalStateException exception = assertThrows(IllegalStateException.class, queue::deQueue);
    assertEquals("Unable to dequeue element from empty queue", exception.getMessage());
  }

  @Test
  @DisplayName("toString returns a string representation of the queue")
  void toStringTest() {
    CircularQueue queue = new CircularQueue(5);

    queue.enQueue(1);
    queue.enQueue(2);

    assertEquals("CircularQueue{[1, 2, 0, 0, 0]}", queue.toString());
  }
}
