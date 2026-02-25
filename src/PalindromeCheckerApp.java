import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string
        String word = "madam";

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both structures
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);       // FIFO
        }

        boolean isPalindrome = true;

        // Compare dequeue vs pop
        for (int i = 0; i < word.length(); i++) {

            char fromQueue = queue.remove();   // FIFO
            char fromStack = stack.pop();      // LIFO

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}