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
    private StringBuilder output = new StringBuilder();
    private StackImpl stack;

    /**
     * Infix2Postfix public constructor
     *
     * @param input Infix expression
     */
    public Infix2Postfix(String input) {
        this.input = input;
        this.stack = new StackImpl(this.input.length());
    }

    /**
     * Convert to Postfix
     *
     * @return String Postfix expression
     */
    public String convert2Postfix() {

        //iterate over the infix expression
        for (int i = 0; i < this.input.length(); i++) {
            this.setElement(this.input.charAt(i));
        }

        //pop operators and append to the postfix expression
        while (!this.stack.isEmpty()) {
            char ch = this.stack.pop().toString().charAt(0);
            this.output.append(ch);
        }

        return this.output.toString(); //final postfix expression
    }

    /**
     * Set Element
     *
     * @param ch element from the operation (operator or operand)
     */
    private void setElement(char ch) {
        switch (ch) {
            case '+':
            case '-':
                this.operatorsPred(ch, 1); //less precedence for + and - operators
                break;
            case '*':
            case '/':
                this.operatorsPred(ch, 2); //more precedence for * and / operators
                break;
            case '(':
                this.stack.push(ch);
                break;
            case ')':
                while (!this.stack.isEmpty()) {
                    char ch2 = this.stack.pop().toString().charAt(0);
                    if (ch2 == '(') { //quit loop if popped item is (
                        break;
                    } else { //otherwise append to the output
                        this.output.append(ch2);
                    }
                }
                break;
            default:
                this.output.append(ch);
                break;
        }
    }

    /**
     * Operators Precedence
     *
     * @param ch1 first operator
     * @param pred precedence from the first operator (1 for + or - ane 2 for *
     * or /)
     */
    private void operatorsPred(char ch1, int pred) {
        while (!this.stack.isEmpty()) {

            char ch2 = this.stack.pop().toString().charAt(0);

            if (ch2 == '(') { //push item if it is (
                this.stack.push(ch2);
                break;
            } else {
                int pred2;

                if (ch2 == '+' || ch2 == '-') {
                    pred2 = 1;
                } else {
                    pred2 = 2;
                }

                if (pred > pred2) { //push operator if it has a higher precedence
                    this.stack.push(ch2);
                    break;
                } else {
                    this.output.append(ch2); //otherwise append to the output
                }
            }
        }
        this.stack.push(ch1); //push operator
    }
}
