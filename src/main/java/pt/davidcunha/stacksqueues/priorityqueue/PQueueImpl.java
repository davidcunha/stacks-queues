/**
 * Stack and Queues - A priority queue implementation
 */
package pt.davidcunha.stacksqueues.priorityqueue;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class PQueueImpl<T> {

    private int max;
    private int nItems;
    private long[] queueArray;

    /**
     * PQueueImpl public constructor
     *
     * @param size structure initialization
     */
    public PQueueImpl(int size) {
        this.max = size;
        this.queueArray = new long[max];
        this.nItems = 0;
    }

    /**
     * Queue getter
     *
     * @return array
     */
    public long[] getQueueArray() {
        return queueArray;
    }

    /**
     * Insert new element in the priority queue. Lower number = higher priority
     */
    public void insert(long n) {
        if (isFull()) {
            throw new IllegalStateException("queue is full");
        } else {
            if (this.nItems == 0) {
                this.queueArray[0] = n;
                this.nItems++;
            } else {
                int j = this.nItems - 1;
                while (j >= 0) {
                    if (n > this.queueArray[j]) {
                        this.queueArray[j + 1] = this.queueArray[j];
                        j--;
                    } else {
                        break;
                    }
                }
                this.queueArray[j + 1] = n;
                this.nItems++;
            }
        }
    }

    /**
     * Remove front of the queue
     *
     */
    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        } else {
            this.nItems--;
        }
    }

    /**
     * Queue peek front of the queue
     *
     * @return first element
     */
    public long peek() {
        return this.queueArray[nItems - 1];
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
}
