/**
 * Stack and Queues - A queue implementation
 */
package pt.davidcunha.stacksqueues.queue;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class QueueImpl {

    private int max;
    private int front;
    private int rear;
    private long[] queueArray;

    public QueueImpl(int size) {
        this.max = size;
        this.front = 0;
        this.rear = size - 1;
        this.queueArray = new long[max];
    }

    public void insert() {
    }

    public long remove() {
    }

    public long peek() {
    }

    public boolean isFull() {
    }

    public boolean isEmpty() {
    }

    public int size() {
    }
}
