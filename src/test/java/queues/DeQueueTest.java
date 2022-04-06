package queues;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dequeue test")
class DeQueueTest {
  @Test
  @DisplayName("isEmpty returns true for a newly initialised queue")
  void isEmptyReturnsTrueForANewlyIntialisedQueueTest() {
    final DeQueue queue = new DeQueue(1);

    assertTrue(queue.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns false for a queue containing elements")
  void isEmptyReturnsFalseForAQueueContainingElementsTest() {
    final DeQueue queue = new DeQueue(1);

    queue.insertBack(1);

    assertFalse(queue.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns true after the last element in a queue has been dequeued")
  void isEmptyReturnsTrueAfterTheLastElementInAQueueHasBeenDequeuedTest() {
    final DeQueue queue = new DeQueue(1);

    queue.insertFront(1);
    queue.removeFront();

    assertTrue(queue.isEmpty());
  }

  @Test
  @DisplayName("isFull returns true for a full queue")
  void isFullReturnsTrueForFullQueueTest() {
    final DeQueue queue = new DeQueue(1);

    queue.insertFront(1);

    assertTrue(queue.isFull());
  }

  @Test
  @DisplayName("isFull returns false for a queue that is not full")
  void isFullReturnsFalseForAQueueThatIsNotFullTest() {
    final DeQueue queue = new DeQueue(2);

    queue.insertFront(1);

    assertFalse(queue.isFull());
  }

  @Test
  @DisplayName("insertFront adds an element to the front of the queue")
  void insertFrontAddsAnElementToTheFrontOfTheQueueTest() {
    final DeQueue queue = new DeQueue(2);

    queue.insertFront(1);
    queue.insertFront(2);

    assertEquals(2, queue.removeFront());
  }

  @Test
  @DisplayName("inserting an element at the front of a full queue throws an IllegalStateException")
  void insertingAnElementAtTheFrontOfAFullQueueThrowsAnIllegalStateExceptionTest() {
    final DeQueue queue = new DeQueue(1);

    queue.insertFront(1);

    final IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> queue.insertFront(2));
    assertEquals("Unable to insert element at front of full queue", exception.getMessage());
  }

  @Test
  @DisplayName("insertBack adds an element to the back of the queue")
  void insertBackAddsAnElementToTheBAckOfTheQueueTest() {
    final DeQueue queue = new DeQueue(2);

    queue.insertBack(1);
    queue.insertBack(2);

    assertEquals(2, queue.removeBack());
  }

  @Test
  @DisplayName("inserting an element at the back of a full queue throws an IllegalStateException")
  void insertingAnElementAtTheBackOfAFullQueueThrowsAnIllegalStateExceptionTest() {
    final DeQueue queue = new DeQueue(1);

    queue.insertFront(1);

    final IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> queue.insertBack(2));
    assertEquals("Unable to insert element at back of full queue", exception.getMessage());
  }

  @Test
  @DisplayName("removeFront removes the element at the front of the queue")
  void removeFrontRemovesTheElementAtTheFrontOfTheQueueTest() {
    final DeQueue queue = new DeQueue(2);

    queue.insertFront(1);
    queue.insertFront(2);

    assertEquals(2, queue.removeFront());
  }

  @Test
  @DisplayName("removeFront on an empty queue throws an IllegalStateException")
  void removeFrontOnAnEmptyQueueThrowsAnIllegalStateExceptionTest() {
    final DeQueue queue = new DeQueue(1);

    final IllegalStateException exception =
        assertThrows(IllegalStateException.class, queue::removeFront);
    assertEquals("Unable to remove element at front of empty queue", exception.getMessage());
  }

  @Test
  @DisplayName("removeBack removes the element at the back of the queue")
  void removeBAckRemovesTheElementAtTheBaOfTheQueueTest() {
    final DeQueue queue = new DeQueue(2);

    queue.insertBack(1);
    queue.insertBack(2);

    assertEquals(2, queue.removeBack());
  }

  @Test
  @DisplayName("removeBack on an empty queue throws an IllegalStateException")
  void removeBackOnAnEmptyQueueThrowsAnIllegalStateExceptionTest() {
    final DeQueue queue = new DeQueue(1);

    final IllegalStateException exception =
        assertThrows(IllegalStateException.class, queue::removeBack);
    assertEquals("Unable to remove element at back of empty queue", exception.getMessage());
  }

  @Test
  @DisplayName("toString returns a string representation of the queue")
  void toStringTest() {
    final DeQueue queue = new DeQueue(5);

    queue.insertBack(1);
    queue.insertBack(2);

    assertEquals("DeQueue{[1, 2, 0, 0, 0]}", queue.toString());
  }
}
