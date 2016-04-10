package se.nackademin;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FortuneTellerTest {

    double delta = 0.01;
    @Test
    public void testCalculate() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        when(magicNumbersMock.calculateA()).thenReturn(1);
        when(magicNumbersMock.calculateB()).thenReturn(1);
        when(magicNumbersMock.calculateC()).thenReturn(1);
        when(magicNumbersMock.calculateD()).thenReturn(1);
        when(magicNumbersMock.calculateE()).thenReturn(1);

        Translator translatorMock = mock(Translator.class);
        when(translatorMock.getAdjective(anyInt())).thenReturn("liten");
        when(translatorMock.getVerb(anyInt())).thenReturn("springa");
        when(translatorMock.getNoun(anyInt())).thenReturn("en lönehöjning");
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        assertEquals("Din framtid är liten. Du borde sluta springa. Vi ser att du snart kommer att skaffa en lönehöjning. Snart kommer du vilja springa, men då är det viktigt att du är liten.", fortuneTeller.calculate());
    }

    @Test
    public void testSetAge() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("25");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setAge(25);
    }

    @Test
    public void testSetAgeWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("not an integer");
        assertFalse("should return false for invalid input", result);
    }
    
    @Test
    public void testSetAgeWithNull(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge(null);
        assertFalse("should return false when age is null", result);
    }
   
   @Test
    public void testSetIncomeWithValidInput(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("10000000");
        assertTrue("Should return true",result);
    }
    
    @Test
    public void testSetIncomeWithInvalidInput(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("10000001");
        assertFalse("Should return false",result);
    }
   
    @Test
    public void testSetIncomeWithInvalidInput2(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("This is not valid income");
        assertFalse("Should return false",result);
    }
    
    @Test
    public void testSetNameValidInput(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setName("Nicklas");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock,times(1)).setName("Nicklas");       
    }
    
    @Test
    public void testSetNameNull(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setName(null);
        assertFalse("should return false for null input", result);
    }

    @Test
    public void testSetNameEmpty(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setName("");
        assertFalse("should return false for null input", result);
    }
    
    
    
    @Test
    public void testSetLocationValidInput(){
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setLocation("Harsas");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock,times(1)).setLocation("Harsas");       
    }
    
    @Test
    public void testSetLocationNull(){
        //TODO:Kolla
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setLocation(null);
        assertFalse("should return false for null input", result);
    }
@Test
    public void testSetLocationEmpty(){
        //TODO:Kolla
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setLocation("");
        assertFalse("should return false for null input", result);
    }
    


    

    @Test
    public void testSetHeight() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setHeight("180");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setHeight(180);
    }

    @Test
    public void testSetHeightWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setHeight("not an integer");
        assertFalse("should return false for invalid input", result);
    }
    
}
