/**
 * Stack and Queues - A queue implementation with circular buffer support
 */
package pt.davidcunha.stacksqueues.queue;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class QueueImpl<T> {

    private int max;
    private int front;
    private int rear;
    private int nItems;
    private boolean circular = false;
    private T[] queueArray;

    /**
     * QueueImpl public constructor
     *
     * @param size structure initialization
     */
    public QueueImpl(int size, boolean circular) {
        this.max = size;
        this.front = 0;
        this.rear = -1;
        this.queueArray = (T[]) new Object[max];
        this.nItems = 0;
        this.circular = circular;
    }

    /**
     * Insert new element in the queue. If queue is full, it overwrites the old
     * elements (circular buffer)
     */
    public void insert(T n) {
        if(this.isFull() && !this.circular) {
            throw new IllegalStateException("queue is full");
        }
        if (this.isFull() && this.circular) {
            this.remove();
        }
        if ((this.rear == this.max - 1) && this.circular) {
            this.rear = -1;
        }
        this.rear++;
        this.queueArray[this.rear] = n;
        this.nItems++;
    }

    /**
     * Remove front of the queue
     *
     * @return first element
     */
    public T remove() {
        T temp = null;
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        } else {
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
    public T peek() {
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
