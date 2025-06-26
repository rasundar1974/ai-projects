// TODO - Implement the FibonacciCalculator class
public class FibonacciCalculator {

    /**
     * Calculates the nth Fibonacci number using an iterative approach.
     *
     * @param n the position in the Fibonacci sequence (0-based index)
     * @return the nth Fibonacci number
     */
    public int calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a non-negative integer");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
