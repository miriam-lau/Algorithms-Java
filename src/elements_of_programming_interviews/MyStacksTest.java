package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyStacksTest {
    MyStacks myStacks;

    @Before public void initialize() {
        myStacks = new MyStacks();
    }

    @Test
    public void evaluateRPNExpression() throws Exception {
        String expression1 = "3, 4, +, 2, x, 2, -, 2, /";
        String expression2 = "1, 1, +, -2, x";
        String expression3 = "";
        String expression4 = "1729";

        assertEquals(6, myStacks.evaluateRPNExpression(expression1));
        assertEquals(-4, myStacks.evaluateRPNExpression(expression2));
        assertEquals(0, myStacks.evaluateRPNExpression(expression3));
        assertEquals(1729, myStacks.evaluateRPNExpression(expression4));
    }

}