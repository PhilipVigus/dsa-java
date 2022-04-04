package stacks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {
  private final T[] arr;
  private final int capacity;
  private int top;

  public Stack(Class<T> clazz, int size) {
    arr = (T[]) Array.newInstance(clazz, size);
    capacity = size;
    top = -1;
  }

  public boolean isFull() {
    return top == capacity - 1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public void push(T elem) {
    if (isFull()) {
      throw new IllegalStateException("Unable to push element to full stack");
    }

    arr[++top] = elem;
  }

  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Unable to pop element from empty stack");
    }

    return arr[top--];
  }

  public int size() {
    return top + 1;
  }

  @Override
  public String toString() {
    return "Stack{" + Arrays.toString(arr) + "}";
  }
}
