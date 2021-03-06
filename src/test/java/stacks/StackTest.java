package stacks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Stack test")
class StackTest {
  @Test
  @DisplayName("isFull returns true when the stack is full")
  void isFullReturnsTrueWhenTheStackIsFullTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 1);
    stack.push(1);

    assertTrue(stack.isFull());
  }

  @Test
  @DisplayName("isFull returns false when the stack is not full")
  void isFullReturnsFalseWhenTheStackIsNotFullTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 2);
    stack.push(1);

    assertFalse(stack.isFull());
  }

  @Test
  @DisplayName("isEmpty returns true for a newly instantiated stack")
  void isEmptyReturnsTrueForANewStackTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    assertTrue(stack.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns false for a stack containing elements")
  void isEmptyReturnsTrueForAStackContainingElementsTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);
    stack.push(1);

    assertFalse(stack.isEmpty());
  }

  @Test
  @DisplayName("isEmpty returns true for a stack that has just popped its only element")
  void isEmptyReturnsTrueForAStackThatHasJustPoppedItsOnlyElementTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);
    stack.push(1);
    stack.pop();

    assertTrue(stack.isEmpty());
  }

  @Test
  @DisplayName("size returns 0 for a newly instantiated stack")
  void sizeReturnsZeroForANewlyInstantiatedStackTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    assertEquals(0, stack.size());
  }

  @Test
  @DisplayName("pushing an element increases a stack's size by one")
  void pushingAnElementIncreasesAStacksSizeByOneTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    assertEquals(0, stack.size());

    stack.push(1);

    assertEquals(1, stack.size());
  }

  @Test
  @DisplayName("popping an element decreases a stack's size by one")
  void poppingAnElementDecreasesAStacksSizeByOneTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    stack.push(1);

    assertEquals(1, stack.size());

    stack.pop();

    assertEquals(0, stack.size());
  }

  @Test
  @DisplayName("pop returns the top element from the stack")
  void popReturnsTheTopElementFromTheStackTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    stack.push(1);
    stack.push(2);

    assertEquals(Integer.valueOf(2), stack.pop());
  }

  @Test
  @DisplayName("popping from an empty stack throws an IllegalStateException")
  void poppingFromAnEmptyStackThrowsAnIllegalStateExceptionTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    final IllegalStateException exception = assertThrows(IllegalStateException.class, stack::pop);
    assertEquals("Unable to pop element from empty stack", exception.getMessage());
  }

  @Test
  @DisplayName("push adds an element to the top of the stack")
  void pushAddsAnElementToTheTopOfTheStackTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    stack.push(1);
    stack.push(2);

    assertEquals(Integer.valueOf(2), stack.pop());
  }

  @Test
  @DisplayName("pushing to a full stack throws an IllegalStateException")
  void pushingToAFullStackThrowsAnIllegalStateExceptionTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 1);

    stack.push(1);

    final IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> stack.push(2));
    assertEquals("Unable to push element to full stack", exception.getMessage());
  }

  @Test
  @DisplayName("toString returns a string representation of the stack")
  void toStringTest() {
    final Stack<Integer> stack = new Stack<>(Integer.class, 5);

    stack.push(1);
    stack.push(2);

    assertEquals("Stack{[1, 2, null, null, null]}", stack.toString());
  }
}
