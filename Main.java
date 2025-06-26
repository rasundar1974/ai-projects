public class Main {
    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator();
        int n = 15; // Example: calculate the 10th Fibonacci number
        int result = calculator.calculate(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
    }
}
