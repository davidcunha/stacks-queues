package pt.davidcunha.stacksqueues;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.davidcunha.stacksqueues.stack.StackImpl;

/**
 * Unit test for Stack Implementation
 */
public class StackTest {
    
    @Test
    public void setup() {
        StackImpl stack = new StackImpl(5);
        assertEquals(true, stack.isEmpty());
        stack.push(20);
        stack.push(30);
        stack.push(50);
        assertEquals(false, stack.isFull());
        stack.push(80);
        stack.push(120);
        assertEquals(true, stack.isFull());
        assertEquals(120L, stack.pop());
    }
    
}
