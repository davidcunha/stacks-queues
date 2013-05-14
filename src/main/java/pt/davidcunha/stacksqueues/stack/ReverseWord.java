/**
 * Stack and Queues - Reverse a word using the stack implementation
 */
package pt.davidcunha.stacksqueues.stack;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class ReverseWord {

    private String word;
    private StackImpl stack;

    public ReverseWord(String input, StackImpl stack) {
        this.word = input;
        this.stack = stack;
    }

    public static ReverseWord setWord(String input) {
        StackImpl stack = new StackImpl(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        return new ReverseWord(input, stack);
    }

    public String reverse() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.word.length() - 1; i >= 0; i--) {
            sb.append(this.stack.pop());
        }
        return sb.toString();
    }
}
