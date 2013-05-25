package pt.davidcunha.stacksqueues;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.davidcunha.stacksqueues.stack.DelimiterMatching;
import pt.davidcunha.stacksqueues.stack.EvaluatePostfix;
import pt.davidcunha.stacksqueues.stack.Infix2Postfix;
import pt.davidcunha.stacksqueues.stack.ReverseWord;
import pt.davidcunha.stacksqueues.stack.StackImpl;

/**
 * Unit test for Stack Implementation
 */
public class StackTest {

    @Test
    public void setup() {
        StackImpl stack = new StackImpl(5);
        assertTrue(stack.isEmpty());
        stack.push('d');
        stack.push('a');
        stack.push('v');
        assertFalse(stack.isFull());
        stack.push('i');
        stack.push('d');
        assertTrue(stack.isFull());
        assertEquals('d', stack.pop());
    }

    @Test
    public void testReverse() {
        ReverseWord revword = ReverseWord.setWord("david");
        assertEquals("divad", revword.reverse());
    }

    @Test
    public void testDelimeterMatching() {
        assertEquals("Code Complete!",
                DelimiterMatching.checkCode("if(var){System.out.println(\"ok\");} else { System.out.println(\"error\")}"));
        assertEquals("Error missing right delimeter for {",
                DelimiterMatching.checkCode("if(var){System.out.println(\"ok\"); else { System.out.println(\"error\")}"));
        assertEquals("Error } at 33",
                DelimiterMatching.checkCode("if(var) System.out.println(\"ok\");} else { System.out.println(\"error\")}"));
    }

    @Test
    public void testInfix2Postfix() {
        Infix2Postfix i2p = new Infix2Postfix("A+B*C");
        assertEquals("ABC*+", i2p.convert2Postfix());

        Infix2Postfix i2p1 = new Infix2Postfix("A*(B+C)");
        assertEquals("ABC+*", i2p1.convert2Postfix());

        Infix2Postfix i2p2 = new Infix2Postfix("A*(B+C)-D/(E+F)");
        assertEquals("ABC+*DEF+/-", i2p2.convert2Postfix());
    }

    @Test
    public void testEvaluatePostfix() {
        Infix2Postfix i2p = new Infix2Postfix("5+5*5");
        System.out.println(i2p.convert2Postfix());
        EvaluatePostfix ep = new EvaluatePostfix(i2p.convert2Postfix());
        assertEquals(30, ep.calculatePostfix());
    }
}
