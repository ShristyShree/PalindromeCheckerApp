public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Step 1: Normalize string
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply two-pointer palindrome logic
        boolean isPalindrome = isPalindrome(normalized);

        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome");
        }
    }

    public static boolean isPalindrome(String word) {

        int start = 0;
        int end = word.length() - 1;

        while (start < end) {

            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}