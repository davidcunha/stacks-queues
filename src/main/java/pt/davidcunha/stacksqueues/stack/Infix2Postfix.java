/**
 * Stack and Queues - Infix to Postfix for parsing arithmetic expressions
 */
package pt.davidcunha.stacksqueues.stack;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class Infix2Postfix {

    private String input;
    private StackImpl stack;

    public Infix2Postfix(String input) {
        this.input = input;
        this.stack = new StackImpl(this.input.length());
    }

    public void convert2Postfix() {
    }

    private void setOperators() {
    }
}
