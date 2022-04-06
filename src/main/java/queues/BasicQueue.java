package queues;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BasicQueue<T> {
  private final T[] arr;
  private final int capacity;
  private int front = -1;
  private int back = -1;

  public BasicQueue(final Class<T> clazz, final int capacity) {
    arr = (T[]) Array.newInstance(clazz, capacity);
    this.capacity = capacity;
  }

  public boolean isFull() {
    return front == 0 && back == capacity - 1;
  }

  public boolean isEmpty() {
    return front == -1;
  }

  public void enQueue(final T elem) {
    if (isFull()) {
      throw new IllegalStateException("Unable to enqueue element to full queue");
    }

    if (front == -1) {
      front = 0;
    }

    back++;

    arr[back] = elem;
  }

  public T deQueue() {
    if (isEmpty()) {
      throw new IllegalStateException("Unable to dequeue element from empty queue");
    }

    final T elem = arr[front];

    if (front >= back) {
      resetPointers();
    } else {
      decrementSize();
    }

    return elem;
  }

  @Override
  public String toString() {
    return "BasicQueue{" + Arrays.toString(arr) + "}";
  }

  private void resetPointers() {
    front = -1;
    back = -1;
  }

  private void decrementSize() {
    front++;
  }
}
