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
        max = size;
        stackArray = new char[max];
        top = -1;
    }

    /**
     * Stack push
     *
     * @param ch append char to the stack
     */
    public void push(char ch) {
        if (!isFull()) {
            top++;
            stackArray[top] = ch;
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
            ch = stackArray[top];
            top--;
        }
        return ch;
    }

    /**
     * Stack peek top of the stack
     *
     * @return last inserted element
     */
    public char peek() {
        return stackArray[top];
    }

    /**
     * Stack is empty?
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Stack is full?
     *
     * @return true or false
     */
    public boolean isFull() {
        return (top == max - 1);
    }
}
