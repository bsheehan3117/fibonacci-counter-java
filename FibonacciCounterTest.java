import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A JUnit test class for the Fibonacci counter class.
 */

public class FibonacciCounterTest {

  private FibonacciCounter counter;

  @Before
  public void setUp() {
    counter = new FibonacciCounter(5);
  }

  // Test the Constructor.
  @Test
  public void testConstructor() {

    FibonacciCounter counterMinusTwo;
    // Test valid input.
    assertEquals(5, counter.getCount());

    // Test throwing an exception.
    try {
      counterMinusTwo = new FibonacciCounter(-2);
      fail("An exception should have been thrown.");
    } catch (IllegalArgumentException e) {
      // The test passes.
    }
  }

  // Test addOne method.
  @Test
  public void testAddOne() {

    FibonacciCounter counterPlusOne = counter.addOne();
    assertEquals(6, counterPlusOne.getCount());
  }

  // Tests the decrement method.
  @Test
  public void testDecrement() {

    FibonacciCounter counterZero;

    FibonacciCounter counterMinusOne = counter.decrement();
    assertEquals(4, counterMinusOne.getCount());

    // Test throwing an exception.
    try {
      counterZero = new FibonacciCounter(0);
      counterZero.decrement();
      fail("An exception should have been thrown.");
    } catch (IllegalArgumentException e) {
      // The test passes.
    }
  }

  // Test the getCount method.
  @Test
  public void testGetCount() {
    assertEquals(5, counter.getCount());
  }

  // Test the get fibonacci method.
  @Test
  public void testGetFibonacciNumber() {

    int actual = counter.getFibonacciNumber();
    assertEquals(5, actual);

    // Test throwing an exception.
    FibonacciCounter counterOverMax;
    try {
      counterOverMax = new FibonacciCounter(48);
      counterOverMax.getFibonacciNumber();
      fail("An exception should have been thrown.");
    } catch (IllegalStateException e) {
      // The test passes.
    }
  }
}