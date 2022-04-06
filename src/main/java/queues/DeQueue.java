package queues;

import java.util.Arrays;

public class DeQueue {
  private final int[] arr;
  private final int size;
  private int front;
  private int back;

  public DeQueue(final int size) {
    arr = new int[size];
    this.size = size;

    front = -1;
    back = 0;
  }

  public boolean isFull() {
    return (front == 0 && back == size - 1) || (front == back + 1);
  }

  public boolean isEmpty() {
    return front == -1;
  }

  public void insertFront(final int elem) {
    if (isFull()) {
      throw new IllegalStateException("Unable to insert element at front of full queue");
    }

    if (front == -1) {
      front = 0;
      back = 0;
    } else if (front == 0) {
      front = size - 1;
    } else {
      front = front - 1;
    }

    arr[front] = elem;
  }

  public void insertBack(final int elem) {
    if (isFull()) {
      throw new IllegalStateException("Unable to insert element at back of full queue");
    }

    if (front == -1) {
      front = 0;
      back = 0;
    } else if (back == size - 1) {
      back = 0;
    } else {
      back = back + 1;
    }

    arr[back] = elem;
  }

  public int removeFront() {
    if (isEmpty()) {
      throw new IllegalStateException("Unable to remove element at front of empty queue");
    }

    final int elem = arr[front];

    if (front == back) {
      front = -1;
      back = -1;
    }

    return elem;
  }

  public int removeBack() {
    if (isEmpty()) {
      throw new IllegalStateException("Unable to remove element at back of empty queue");
    }

    final int elem = arr[back];

    if (front == back) {
      front = -1;
      back = -1;
    } else if (back == 0) {
      back = size - 1;
    } else {
      back = back - 1;
    }

    return elem;
  }

  @Override
  public String toString() {
    return "DeQueue{" + Arrays.toString(arr) + "}";
  }
}
