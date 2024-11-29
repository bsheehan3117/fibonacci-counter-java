/**
 * This class represents a Fibonacci counter.
 * The counter tracks the number of fibonacci numbers.
 */

public class FibonacciCounter {
  public int counter;

  /**
   * Constructs a FibonacciCounter object and intitializes
   * it to the given counter value.
   *     @param initialCount The initial count.
   *     @throws IllegalArgumentException If counter is less than 0.
   */

  public FibonacciCounter(int initialCount) {

    this.counter = initialCount;

    if (counter <= 0) {
      throw new IllegalArgumentException("Counter cannot be below zero.");
    }
  }

  /**
   * Adds one to the fibonacci counter.
   *     @return The fibonacci counter with its
   *     count increased by one.
   */

  public FibonacciCounter addOne() {

    int countPlusOne = counter + 1;

    return new FibonacciCounter(countPlusOne);
  }

  /**
   * Subtracts one from the fibonacci counter.
   *     @return The fibonacci counter with its
   *     count decreased by one.
   *     @throws IllegalArgumentException If the method
   *     results in the counter being less than zero.
   */

  public FibonacciCounter decrement() {

    int countMinusOne = counter - 1;

    if (counter < 0) {
      throw new IllegalArgumentException("Counter cannot be below zero.");
    }
    return new FibonacciCounter(countMinusOne);
  }

  /**
   * Returns the current count of the counter.
   *     @return The current count of the counter.
   */

  public int getCount() {
    return counter;
  }

  /**
   * A method that uses Binet's formula to
   * return a fibonacci number
   * corresponding to the current count.
   *     @return A fibonacci number.
   *     @throws IllegalStateException If the number
   *     does not fit into an int.
   */

  public int getFibonacciNumber() {

    // Implementing Binet's formula
    // Left side parentheses
    double leftHalfEquation = Math.pow((1 + Math.sqrt(5)) / 2, counter);

    // Right side parentheses
    double rightHalfEquation = Math.pow((1 - Math.sqrt(5)) / 2, counter);

    // Subtract inside parentheses
    double leftMinusRight = leftHalfEquation - rightHalfEquation;

    // Multiply by one divided by the square root of 5.
    // Store result in long.
    long result = (long) (1 / Math.sqrt(5) * leftMinusRight);

    // Determine if number fits into int.
    // Throw exception if not.
    if (result > Integer.MAX_VALUE) {
      throw new IllegalStateException("Fibonacci number does not fit in int.");
    }
    return (int) result;
  }
}