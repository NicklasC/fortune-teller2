package se.nackademin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FortuneTellerIT {

    @Test
    public void testGetFortune() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("16");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("11000");
        fortuneTeller.setLocation("Hagfors");
        fortuneTeller.setName("Sture Hagfors");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }
    @Test
    public void testNegativeIncomeOK() {
        // Verifies Issue #37:  Svante/-10000/Malmö/27/0 gave ArrayIndexOutOfBoundsException
        // Löst genom att ignorera tecken på inkomst (ex. -10000 = 10000)
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("0");
        fortuneTeller.setIncome("-10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setName("Svante");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en hund. Snart kommer du vilja mäta, men då är det viktigt att du är stor.", output);
    }
    @Test
    public void testIssue38() {
        // Issue #38: Svante/10000/Malmö/27/0 ger ArrayIndexOutOfBoundsException
        // Löst genom att tvinga C att vara negativ innan man kommer in i while-loopen.
        
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("0");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setName("Svante");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en hund. Snart kommer du vilja mäta, men då är det viktigt att du är stor.", output);
    }
    
    @Test
    public void testIssue39() {
        // Issue #39: Svante/10000/Malmö/-5/165 ger ArrayIndexOutOfBoundsException
        // Löst genom att ignorera tecken på ålder (ex. -27 = 27)        
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("-5");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setName("Svante");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är snabb. Du borde sluta resa. Vi ser att du snart kommer att skaffa en lönehöjning. Snart kommer du vilja äta, men då är det viktigt att du är mörk.", output);
    }
    @Test
    public void testIssue40() {
        // Issue #39: Svante/10000/Malmö/-5/165 ger ArrayIndexOutOfBoundsException
        // Löst genom att ignorera tecken på ålder (ex. -27 = 27)        
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("-20");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setName("Svante");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa ett barn. Snart kommer du vilja mäta, men då är det viktigt att du är ljus.", output);
    }
    
    @Test
    public void testIssue41() {
        // Issue #39: Svante/10000/Malmö/-5/165 ger ArrayIndexOutOfBoundsException
        // Löst genom att ignorera tecken på ålder (ex. -27 = 27)        
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("0");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setName("Svante");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta äta. Vi ser att du snart kommer att skaffa ett elstängsel. Snart kommer du vilja röra, men då är det viktigt att du är stor.", output);
    }
    @Test
    public void testSetAgeIsNull(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result=fortuneTeller.setAge(null);
        
        assertFalse("should return false for null value", result);
        //assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta äta. Vi ser att du snart kommer att skaffa ett elstängsel. Snart kommer du vilja röra, men då är det viktigt att du är stor.", output);
    
    }

    @Test
    public void testSetHeightIsNull(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result=fortuneTeller.setHeight(null);
        
        assertFalse("should return false for null value", result);
    }

    @Test
    public void testSetNameWhenNullOrEmpty(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result;
        
        result=fortuneTeller.setName(null);
        assertFalse("should return false for null value", result);
        
        result=fortuneTeller.setName("");
        assertFalse("should return false when empty", result);
    }

    @Test
    public void testSetLocationWhenNullOrEmpty(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result;
        
        result=fortuneTeller.setLocation(null);
        assertFalse("should return false for null value", result);
        
        result=fortuneTeller.setLocation("");
        assertFalse("should return false when empty", result);
    }
    @Test
    public void testSetIncomeValid1(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result;
        
        result = fortuneTeller.setIncome("5");
        assertTrue("should return true when Income is 5", result);
    }
    
    @Test
    public void testSetIncomeBorder(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result;
        
        result = fortuneTeller.setIncome("10000000");
        assertTrue("should return true when Income is 10000000", result);
    
    }
    
    @Test
    public void testSetIncomeOutOfBounds(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result;

        result = fortuneTeller.setIncome("90000001");
        assertFalse("should return false when Income is 90000001", result);

    }

    @Test
    public void testSetIncomeNaN(){
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result;
        
        result = fortuneTeller.setIncome("This is not a valid number");
        assertFalse("should return false when a non-number is entered", result);
    }
    
}
