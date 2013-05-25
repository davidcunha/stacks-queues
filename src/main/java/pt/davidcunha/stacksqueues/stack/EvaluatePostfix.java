/**
 * Stack and Queues - Evaluate Postfix expressions
 */
package pt.davidcunha.stacksqueues.stack;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class EvaluatePostfix {

    private String input;
    private StackImpl stack;

    /**
     * EvaluatePostfix public constructor
     *
     * @param input Postfix expression
     */
    public EvaluatePostfix(String input) {
        this.input = input;
        this.stack = new StackImpl(this.input.length());
    }

    /**
     * Calculate result from Postfix expression
     *
     * @return int result
     */
    public int calculatePostfix() {

        for (int i = 0; i < this.input.length(); i++) {
            this.setElement(this.input.charAt(i));
        }

        return Integer.valueOf(this.stack.pop().toString());
    }

    /**
     * Set Element
     *
     * @param ch element from the operation (operator or operand)
     */
    public void setElement(char ch) {
        if (ch >= '0' && ch <= '9') {
            this.stack.push((int) (ch - '0'));
        } else {
            int result = 0;
            String t = this.stack.pop().toString();
            int b = Integer.valueOf(t);
            int a = Integer.valueOf(this.stack.pop().toString());
            switch (ch) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
            }
            System.out.println(result);
            this.stack.push(result);
        }
    }
}
