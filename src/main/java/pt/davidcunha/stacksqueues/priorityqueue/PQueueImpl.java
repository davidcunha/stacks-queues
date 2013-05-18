/**
 * Stack and Queues - A priority queue implementation
 */
package pt.davidcunha.stacksqueues.priorityqueue;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class PQueueImpl {

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

    public boolean isFull() {
        return (nItems == max);
    }
}
