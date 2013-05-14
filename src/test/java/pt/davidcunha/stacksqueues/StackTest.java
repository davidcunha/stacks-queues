package pt.davidcunha.stacksqueues;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.davidcunha.stacksqueues.stack.ReverseWord;
import pt.davidcunha.stacksqueues.stack.StackImpl;

/**
 * Unit test for Stack Implementation
 */
public class StackTest {

    @Test
    public void setup() {
        StackImpl stack = new StackImpl(5);
        assertEquals(true, stack.isEmpty());
        stack.push('d');
        stack.push('a');
        stack.push('v');
        assertEquals(false, stack.isFull());
        stack.push('i');
        stack.push('d');
        assertEquals(true, stack.isFull());
        assertEquals('d', stack.pop());
    }

    @Test
    public void testReverse() {
        ReverseWord revword = ReverseWord.setWord("david");
        assertEquals("divad", revword.reverse());
    }
}
