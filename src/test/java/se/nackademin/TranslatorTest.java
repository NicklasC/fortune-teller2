/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicklas
 */
public class TranslatorTest {
    
    double delta = 0.01;
        
    
    @Test
    public void testGetNoun(){
        Translator translator = new Translator();
        String result = translator.getNoun(0);
        //boolean result;
        //assertTrue("should return true for valid input", result);
        assertEquals("Return value should be 'en lönehöjning'","en lönehöjning",result);
    }
    @Test
    public void testGetAdjective(){
        Translator translator = new Translator();
        String result = translator.getAdjective(0);
        //boolean result;
        //assertTrue("should return true for valid input", result);
        assertEquals("Return value should be 'stor'","stor",result);
    }
    @Test
    public void testGetVerb(){
        Translator translator = new Translator();
        String result = translator.getVerb(0);
        //boolean result;
        //assertTrue("should return true for valid input", result);
        assertEquals("Return value should be 'springa'","springa",result);
    }
    
}
