/**
 * Stack and Queues - A stack implementation
 */
package pt.davidcunha.stacksqueues.stack;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class StackImpl<T> {

    private int max;
    private int top;
    private T[] stackArray;

    /**
     * StackImpl public constructor
     *
     * @param size structure initialization
     */
    public StackImpl(int size) {
        this.max = size;
        this.stackArray = (T[]) new Object[this.max];
        this.top = -1;
    }

    /**
     * Stack push
     *
     * @param ch append type to the stack
     */
    public void push(T ch) {
        if (isFull()) {
            System.out.println("stack is full");
        } else {
            this.top++;
            stackArray[this.top] = ch;
        }
    }

    /**
     * Stack pop
     *
     * @return last inserted element
     */
    public T pop() {
        T ch = null;
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
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
    public T peek() {
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
        return (this.top == this.max - 1);
    }
}
