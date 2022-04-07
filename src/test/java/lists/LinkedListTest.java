package lists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LinkedList test")
class LinkedListTest {
  @Test
  @DisplayName("insertStart inserts a node at the start of the list")
  void insertStartInsertsANodeAtTheStartOfTheList() {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    list.insertStart(1);
    list.insertStart(2);

    assertEquals("LinkedList{2 1 }", list.toString());
  }

  @Test
  @DisplayName("insertEnd inserts a node at the end of the list")
  void insertInsertsANodeAtTheEndOfTheList() {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    list.insertEnd(1);
    list.insertEnd(2);

    assertEquals("LinkedList{1 2 }", list.toString());
  }

  @Test
  @DisplayName("deleteNode can delete a node from start of the list")
  void deleteNodeCanDeleteANodeFromTheStartOfTheList() {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    list.insertEnd(1);
    list.insertEnd(2);

    list.deleteNode(1);

    assertEquals("LinkedList{2 }", list.toString());
  }

  @Test
  @DisplayName("deleteNode can delete a node from end of the list")
  void deleteNodeCanDeleteANodeFromTheEndOfTheList() {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    list.insertEnd(1);
    list.insertEnd(2);

    list.deleteNode(2);

    assertEquals("LinkedList{1 }", list.toString());
  }

  @Test
  @DisplayName("deleteNode can delete a node from middle of the list")
  void deleteNodeCanDeleteANodeFromTheMiddleOfTheList() {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    list.insertEnd(1);
    list.insertEnd(2);
    list.insertEnd(3);

    list.deleteNode(2);

    assertEquals("LinkedList{1 3 }", list.toString());
  }
}
