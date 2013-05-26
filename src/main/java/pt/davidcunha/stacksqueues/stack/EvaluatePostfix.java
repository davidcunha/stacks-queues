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

        //iterate over the postfix expression
        for (int i = 0; i < this.input.length(); i++) {
            this.setElement(this.input.charAt(i));
        }

        return Integer.valueOf(this.stack.pop().toString()); //pop final result
    }

    /**
     * Set Element
     *
     * @param ch element from the operation (operator or operand)
     */
    public void setElement(char ch) {
        if (ch >= '0' && ch <= '9') { //accepts only single digit numbers
            this.stack.push((int) (ch - '0')); //convert operand to int and push it
        } else {
            int result = 0;
            //pop the last 2 elements
            int b = Integer.valueOf(this.stack.pop().toString());
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
            this.stack.push(result); //push result from the operation
        }
    }
}
