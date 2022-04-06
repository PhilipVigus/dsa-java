package queues;

import java.util.Arrays;

public class CircularQueue {
  private final int capacity;
  private int front;
  private int back;
  private int[] arr;

  public CircularQueue(final int capacity) {
    this.capacity = capacity;
    this.arr = new int[capacity];
    front = -1;
    back = -1;
  }

  public boolean isFull() {
    return (front == 0 && back == capacity - 1) || (front == back + 1);
  }

  public boolean isEmpty() {
    return front == -1;
  }

  public void enQueue(int elem) {
    if (isFull()) {
      throw new IllegalStateException("Unable to enqueue element to full queue");
    }

    if (front == -1) {
      front = 0;
    }

    back = (back + 1) % capacity;
    arr[back] = elem;
  }

  public int deQueue() {
    if (isEmpty()) {
      throw new IllegalStateException("Unable to dequeue element from empty queue");
    }

    int elem = arr[front];

    if (front == back) {
      resetPointers();
    } else {
      decrementSize();
    }

    return elem;
  }

  private void resetPointers() {
    front = -1;
    back = -1;
  }

  private void decrementSize() {
    front = (front + 1) % capacity;
  }

  @Override
  public String toString() {
    return "CircularQueue{" + Arrays.toString(arr) + "}";
  }
}
