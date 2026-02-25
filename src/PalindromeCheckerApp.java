import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama"
                .replaceAll("\\s+", "")
                .toLowerCase();

        System.out.println("Input Length: " + input.length());
        System.out.println("-----------------------------------");

        // Two Pointer
        long start = System.nanoTime();
        boolean result1 = twoPointer(input);
        long end = System.nanoTime();
        long time1 = end - start;

        // Stack
        start = System.nanoTime();
        boolean result2 = stackMethod(input);
        end = System.nanoTime();
        long time2 = end - start;

        // Deque
        start = System.nanoTime();
        boolean result3 = dequeMethod(input);
        end = System.nanoTime();
        long time3 = end - start;

        // Recursive
        start = System.nanoTime();
        boolean result4 = recursiveMethod(input, 0, input.length() - 1);
        end = System.nanoTime();
        long time4 = end - start;

        System.out.println("Two Pointer Result : " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Stack Method Result: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Deque Method Result: " + result3 + " | Time: " + time3 + " ns");
        System.out.println("Recursive Result   : " + result4 + " | Time: " + time4 + " ns");
    }

    // 1️⃣ Two Pointer Method
    public static boolean twoPointer(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 2️⃣ Stack Method
    public static boolean stackMethod(String input) {
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

    // 3️⃣ Deque Method
    public static boolean dequeMethod(String input) {
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

    // 4️⃣ Recursive Method
    public static boolean recursiveMethod(String input, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }
        return recursiveMethod(input, start + 1, end - 1);
    }
}