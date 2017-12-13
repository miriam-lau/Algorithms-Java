package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyStringsTest {
    MyStrings myStrings;

    @Before public void initialize() {
        myStrings = new MyStrings();
    }

    @Test
    public void isPalindrome() throws Exception {
        String s1 = "A man, a plan, a canal, Panama.";
        String s2 = "Able was I, ere I saw Elba!";
        String s3 = "";
        String s4 = "Ray a Ray?";
        String s5 = "A9 9A";

        assertEquals(true, myStrings.isPalindrome(s1));
        assertEquals(true, myStrings.isPalindrome(s2));
        assertEquals(true, myStrings.isPalindrome(s3));
        assertEquals(false, myStrings.isPalindrome(s4));
        assertEquals(true, myStrings.isPalindrome(s5));
    }

    @Test
    public void reverseWordOrder() throws Exception {
        String s1 = "Sailor Moon likes Tuxedo Mask";
        String s2 = "Serena";
        String s3 = "";

        assertEquals("Mask Tuxedo likes Moon Sailor", myStrings.reverseWordOrder(s1));
        assertEquals("Serena", myStrings.reverseWordOrder(s2));
        assertEquals("", myStrings.reverseWordOrder(s3));

    }
}