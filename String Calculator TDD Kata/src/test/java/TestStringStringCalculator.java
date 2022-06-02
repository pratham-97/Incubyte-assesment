import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStringStringCalculator {

    StringCalculator stringStringCalculator =new StringCalculator();
    @Test
    public void testEmptyString() {
        assertEquals(0, StringCalculator.Add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals(1, StringCalculator.Add("1"));
    }

    @Test
    public void testTwoNumbers(){
        assertEquals(3, StringCalculator.Add("1,2"));
    }

    @Test
    public void testThreeNumbers(){
        assertEquals(6, StringCalculator.Add("1,2,3"));
    }

    @Test
    public void testNewLine(){
        assertEquals(6, StringCalculator.Add("1\n2,3"));
    }

    @Test
    public void testNegativeNumber(){
        try {
            StringCalculator.Add("-1,2");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }

        try {
            StringCalculator.Add("2,-4,3,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
        }
    }
    @Test
    public void testOtherDelimiter(){
        assertEquals(3, StringCalculator.Add("//*\n1*2"));
    }
}
