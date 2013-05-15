/**
 * Stack and Queues - A stack implementation
 */
package pt.davidcunha.stacksqueues.stack;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class StackImpl {

    private int max;
    private int top;
    private char[] stackArray;

    /**
     * StackImpl public constructor
     *
     * @param size array initialization
     */
    public StackImpl(int size) {
        this.max = size;
        this.stackArray = new char[max];
        this.top = -1;
    }

    /**
     * Stack push
     *
     * @param ch append char to the stack
     */
    public void push(char ch) {
        if (!isFull()) {
            this.top++;
            stackArray[this.top] = ch;
        }
    }

    /**
     * Stack pop
     *
     * @return last inserted element
     */
    public char pop() {
        char ch = '\u0000';
        if (!isEmpty()) {
            ch = stackArray[this.top];
            this.top--;
        }
        return ch;
    }

    /**
     * Stack peek top of the stack
     *
     * @return last inserted element
     */
    public char peek() {
        return stackArray[this.top];
    }

    /**
     * Stack is empty?
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return (this.top == -1);
    }

    /**
     * Stack is full?
     *
     * @return true or false
     */
    public boolean isFull() {
        return (this.top == max - 1);
    }
}
