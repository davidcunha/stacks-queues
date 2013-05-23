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

    public Infix2Postfix(String input) {
        this.input = input;
        this.stack = new StackImpl(this.input.length());
    }

    public String convert2Postfix() {

        for (int i = 0; i < this.input.length(); i++) {
            System.out.println("For " + this.input.charAt(i));
            this.setOperators(this.input.charAt(i));
        }

        while (!this.stack.isEmpty()) {
            char ch = this.stack.pop().toString().charAt(0);
            System.out.println("Stack " + ch);
            this.output.append(ch);
        }

        return this.output.toString();
    }

    private void setOperators(char ch) {
        switch (ch) {
            case '+':
            case '-':
                if (this.stack.isEmpty()) {
                    this.stack.push(ch);
                } else {
                    this.operatorsPred(ch, 1);
                }
                break;
            case '*':
            case '/':
                if (this.stack.isEmpty()) {
                    this.stack.push(ch);
                } else {
                    this.operatorsPred(ch, 2);
                }
                break;
            case '(':
                this.stack.push(ch);
                break;
            case ')':
                while (!this.stack.isEmpty()) {
                    char ch2 = this.stack.pop().toString().charAt(0);
                    if (ch2 == '(') {
                        break;
                    } else {
                        this.output.append(ch2);
                    }
                }
                break;
            default:
                this.output.append(ch);
                break;
        }
    }

    private void operatorsPred(char ch1, int pred) {
        while (!this.stack.isEmpty()) {

            char ch2 = this.stack.pop().toString().charAt(0);

            if (ch2 == '(') {
                this.stack.push(ch2);
                break;
            } else {
                int pred2;

                if (ch2 == '+' || ch2 == '-') {
                    pred2 = 1;
                } else {
                    pred2 = 2;
                }

                if (pred > pred2) {
                    this.stack.push(ch2);
                    break;
                } else {
                    this.output.append(ch2);
                }
            }
        }
        this.stack.push(ch1);
    }

    public static void main(String args[]) {
        Infix2Postfix inf2post = new Infix2Postfix("A*(B+C)-D/(E+F)");
        System.out.println(inf2post.convert2Postfix());
    }
}
