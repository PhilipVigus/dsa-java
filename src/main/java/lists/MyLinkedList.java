package lists;

public class MyLinkedList<T> {
  private MyNode<T> head;

  public void insertStart(final T data) {
    final MyNode<T> newNode = new MyNode<>(data);

    newNode.next = head;
    head = newNode;
  }

  public void insertEnd(final T data) {
    final MyNode<T> newNode = new MyNode<>(data);

    if (head == null) {
      head = newNode;
      return;
    }

    MyNode<T> last = head;

    while (last.next != null) {
      last = last.next;
    }

    last.next = newNode;
  }

  public void deleteNode(T value) {
    if (head == null) {
      return;
    }

    if (head.value == value) {
      head = head.next;
      return;
    }

    MyNode<T> temp = head;
    MyNode<T> prev = null;

    while (temp != null && temp.value != value) {
      prev = temp;
      temp = temp.next;
    }

    if (temp == null) {
      return;
    }

    prev.next = temp.next;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("LinkedList{");

    MyNode<T> node = head;

    while (node != null) {
      builder.append(node.value).append(" ");
      node = node.next;
    }

    builder.append("}");

    return builder.toString();
  }

  static class MyNode<T> {
    T value;
    MyNode<T> next;

    public MyNode(T value) {
      this.value = value;
      next = null;
    }
  }
}
