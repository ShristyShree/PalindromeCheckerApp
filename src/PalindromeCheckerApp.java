import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeService {

    private PalindromeStrategy strategy;

    // Constructor Injection
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";

        // Choose Strategy Dynamically
        PalindromeStrategy strategy;

        // Change here to test different algorithms
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.checkPalindrome(input);

        if (result) {
            System.out.println("Using " + strategy.getClass().getSimpleName());
            System.out.println("\"" + input + "\" is a Palindrome");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome");
        }
    }
}