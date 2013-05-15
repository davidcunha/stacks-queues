/**
 * Stack and Queues - A queue implementation with circular buffer support
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
    private int nItems;
    private long[] queueArray;

    /**
     * QueueImpl public constructor
     *
     * @param size array initialization
     */
    public QueueImpl(int size) {
        this.max = size;
        this.front = 0;
        this.rear = -1;
        this.queueArray = new long[max];
        this.nItems = 0;
    }

    /**
     * Insert new element in the queue
     *
     */
    public void insert(long n) {
        if (!isFull()) {
            if (this.rear == this.max - 1) {
                this.rear = -1;
            }
            this.rear++;
            this.queueArray[this.rear] = n;
            this.nItems++;
        }
    }

    /**
     * Remove front of the queue
     *
     * @return first element
     */
    public long remove() {
        long temp = 0L;
        if (!isEmpty()) {
            temp = this.queueArray[this.front];
            this.front++;
            if (this.front == this.max) {
                this.front = 0;
            }
            this.nItems--;
        }
        return temp;
    }

    /**
     * Queue peek front of the queue
     *
     * @return first element
     */
    public long peek() {
        return this.queueArray[front];
    }

    /**
     * Queue is empty?
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return (this.nItems == 0);
    }

    /**
     * Queue is full?
     *
     * @return true or false
     */
    public boolean isFull() {
        return (this.nItems == this.max);
    }

    /**
     * Queue size
     *
     * @return number of elements
     */
    public int size() {
        return this.nItems;
    }
}
