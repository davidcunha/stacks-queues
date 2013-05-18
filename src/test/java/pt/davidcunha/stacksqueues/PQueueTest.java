package pt.davidcunha.stacksqueues;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import pt.davidcunha.stacksqueues.priorityqueue.PQueueImpl;

/**
 * Unit test for PQueue Implementation
 */
public class PQueueTest {

    @Test
    public void setup() {
        PQueueImpl pqueue = new PQueueImpl(5);
        pqueue.insert(20);
        pqueue.insert(30);
        pqueue.insert(10);
        pqueue.insert(40);
        pqueue.insert(5);
        assertTrue(Arrays.equals(new long[]{40, 30, 20, 10, 5}, pqueue.getQueueArray()));
    }

    @Test(expected = IllegalStateException.class)
    public void testFullness() {
        PQueueImpl pqueue = new PQueueImpl(5);
        pqueue.insert(20);
        pqueue.insert(30);
        pqueue.insert(10);
        pqueue.insert(40);
        pqueue.insert(5);
        pqueue.insert(2);
    }

}
