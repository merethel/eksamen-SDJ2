package JUnitTesting.queue;

import JUnitTesting.queueimpls.SimpleBoundedArrayQueueCorrect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest
{
  private QueueADT<String> getQueue(int capacity) {
    return new SimpleBoundedArrayQueueCorrect<>(capacity);
  }

  QueueADT<String> queue;

  @Test
  public void testConstructorNegativeCap() {
    getQueue(-1);
    assertThrows(NullPointerException.class, () -> queue.size());
  }

  @Test
  public void enqueueString() {
    queue = getQueue(5);
    queue.enqueue("en");
    assertEquals("en", queue.first());
  }

  @Test
  public void enqueueNull() {
    queue = getQueue(5);
    assertThrows(IllegalArgumentException.class, () -> queue.enqueue(null));
  }

  @Test
  public void enqueuePastCapacity() {
    queue = getQueue(5);
    for (int i = 0; i < 5; i++) {
      queue.enqueue("a");
    }
    assertThrows(IllegalStateException.class, () -> queue.enqueue("a"));
  }

  @Test
  public void dequeueFromEmptyQueue() {
    queue = getQueue(5);
    assertThrows(IllegalStateException.class, () -> queue.dequeue());
    queue.enqueue("a");
    assertDoesNotThrow(() -> queue.dequeue());
    assertThrows(IllegalStateException.class, () -> queue.dequeue());
  }

  @Test
  public void dequeueCorrectSequence() {
    queue = getQueue(5);
    queue.enqueue("en");
    queue.enqueue("to");
    queue.enqueue("tre");
    assertEquals("en", queue.dequeue());
    assertEquals("to", queue.dequeue());
    queue.enqueue("fire");
    assertEquals("tre", queue.dequeue());
    assertEquals("fire", queue.dequeue());
  }

  @Test
  public void firstOnEmptyQueue() {
    queue = getQueue(5);
    assertThrows(IllegalStateException.class, () -> queue.first());
    queue.enqueue("a");
    assertDoesNotThrow(() -> queue.first());
    queue.dequeue();
    assertThrows(IllegalStateException.class, () -> queue.first());
  }

  @Test
  public void testFirst() {
    queue = getQueue(5);
    queue.enqueue("en");
    queue.enqueue("to");
    queue.enqueue("tre");
    assertEquals("en", queue.first());
    assertEquals("en", queue.dequeue());
    assertEquals("to", queue.first());
    assertEquals("to", queue.dequeue());
    assertEquals("tre", queue.first());
    assertEquals("tre", queue.dequeue());
  }

  @Test
  public void testSizeEmptyQueue() {
    queue = getQueue(5);
    assertEquals(0, queue.size());
  }

  @Test

  public void testSizeNonEmptyQueue() {
    queue = getQueue(5);
    assertEquals(0, queue.size());
    queue.enqueue("en");
    assertEquals(1, queue.size());
    queue.enqueue("to");
    assertEquals(2, queue.size());
    queue.enqueue("tre");
    assertEquals(3, queue.size());
  }

  @Test
  public void testisEmpty() {
    queue = getQueue(5);
    assertTrue(queue.isEmpty());
    queue.enqueue("en");
    assertFalse(queue.isEmpty());
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void testIndexEfterEnqueue() {
    queue = getQueue(5);
    queue.enqueue("en");
    queue.enqueue("to");
    queue.enqueue("tre");
    queue.enqueue("en");
    assertEquals(0, queue.indexOf("en"));
    assertEquals(1, queue.indexOf("to"));
    assertEquals(2, queue.indexOf("tre"));
    queue.dequeue();
    assertEquals(0, queue.indexOf("to"));
    assertEquals(1, queue.indexOf("tre"));
    assertEquals(2, queue.indexOf("en"));
    queue.dequeue();
    assertEquals(-1, queue.indexOf("to"));
    assertEquals(0, queue.indexOf("tre"));
    assertEquals(1, queue.indexOf("en"));
  }

  @Test
  public void testContainsEmptyQueue() {
    //error in SimpleBoundedArrayQueueCorrect found
    queue = getQueue(5);
    assertFalse(queue.contains("en"));
  }

  @Test
  public void testContainsAfterEnqueue() {
    queue = getQueue(5);
    queue.enqueue("en");
    queue.enqueue("to");
    queue.enqueue("tre");
    assertTrue(queue.contains("en"));
    assertTrue(queue.contains("to"));
    assertTrue(queue.contains("tre"));
    assertFalse(queue.contains("fire"));
    queue.dequeue();
    assertFalse(queue.contains("en"));
  }

  @Test
  public void testToStringEmptyQueue() {
    queue = getQueue(5);
    assertEquals("{}", queue.toString());
  }

  @Test
  public void testToStringAfterEnqueue() {
    queue = getQueue(5);
    queue.enqueue("en");
    queue.enqueue("to");
    queue.enqueue("tre");
    queue.enqueue("fire");
    queue.enqueue("fem");
    assertEquals("{en, to, tre, fire, fem}", queue.toString());
  }
}