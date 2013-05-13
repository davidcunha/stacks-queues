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
    private long[] stackArray;

    /**
     * StackImpl public constructor
     *
     * @param size array initialization
     */
    public StackImpl(int size) {
        max = size;
        stackArray = new long[max];
        top = -1;
    }

    /**
     * Stack public constructor
     *
     * @param size array initialization
     */
    public void push(long n) {
        if (!isFull()) {
            top++;
            stackArray[top] = n;
        }
    }

    /**
     * Stack pop
     *
     * @return last inserted element
     */
    public long pop() {
        long n = 0L;
        if (!isEmpty()) {
            n = stackArray[top];
            top--;
        }
        return n;
    }

    /**
     * Stack peek top of the stack
     *
     * @return last inserted element
     */
    public long peek() {
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
