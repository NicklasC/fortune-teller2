package se.nackademin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.*;

public class MagicNumberTest {
    MagicNumbers magicNumbers;
    boolean res;

    @Before
    public void setUp() {
        magicNumbers = new MagicNumbers();
        magicNumbers.setAge(16);
        magicNumbers.setHeight(165);
        magicNumbers.setIncome(11000);
        magicNumbers.setLocation("Hagfors");
        magicNumbers.setName("Sture Hagfors");
    }

    @Test
    public void testA() {
        assertEquals("A is not calculated correctly", 4, magicNumbers.calculateA());
    }

    @Test
    public void testB() {
        assertEquals("B is not calculated correctly", 3, magicNumbers.calculateB());
    }

    @Test
    public void testC() {
        assertEquals("C is not calculated correctly", 2, magicNumbers.calculateC());
    }

    @Test
    public void testD() {
        assertEquals("D is not calculated correctly", 6, magicNumbers.calculateD());
    }

    @Test
    public void testDWithAGreaterThan5() {
        magicNumbers.setAge(18);
        assertEquals("D is not calculated correctly", 9, magicNumbers.calculateD());
    }

    @Test
    public void testE() {
        assertEquals("E is not calculated correctly", 9, magicNumbers.calculateE());
    }

    @Test
    public void testADependsOnName() {
        int first = magicNumbers.calculateA();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different names", first, second);
    }

    @Test
    public void testADependsOnAge() {
        int first = magicNumbers.calculateA();
        magicNumbers.setAge(18);
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different ages", first, second);
    }

    @Test
    public void testBDependsOnLocation() {
        int first = magicNumbers.calculateB();
        magicNumbers.setLocation("Grytevik");
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different locations", first, second);
    }

    @Test
    public void testBDependsOnIncome() {
        int first = magicNumbers.calculateB();
        magicNumbers.setIncome(219487);
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different income values", first, second);
    }

    @Test
    public void testCDependsOnHeight() {
        int first = magicNumbers.calculateC();
        magicNumbers.setHeight(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different heights", first, second);
    }

    @Test
    public void testCDependsOnAge() {
        int first = magicNumbers.calculateC();
        magicNumbers.setAge(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different ages", first, second);
    }

    @Test
    public void testCDependsOnName() {
        int first = magicNumbers.calculateC();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different names", first, second);
    }
    @Test
    public void VerifyCalculateAImplementation(){
        
        String location;
        String name="";
        
        
        magicNumbers.setAge(1);
        
        for(int counter = 0;counter <=10;counter++){
            name="";
            for (int i = 0; i <= counter; i++){
               name = name + "a a";
            }

            magicNumbers.setName(name);
            int calcA=magicNumbers.calculateA();

            if(calcA >=0 && calcA <=9){
                res=true;
            }
            else{
                res=false;
            }
            assertTrue("calculateA with input name '" + name +"' and age '1' should return between 0 and 9, but returned '"+calcA+"'", res);
        }
    
    }
    
    @Test
    public void VerifyCalculateBImplementation(){
        
        magicNumbers.setLocation("here");
        for(int counter=0;counter<=30;counter++){
            magicNumbers.setIncome(counter);
        
            int calcB=magicNumbers.calculateB();
            if(calcB >=0 && calcB <=9){
                res=true;
            }
            else{
                res=false;
            }
            assertTrue("calculateB with location 'here' and income '"+ counter +"' should return between 0 and 9, but returned '"+calcB+"'", res);
        }
    }
    
    @Test
    public void VerifyCalculateCImplementation(){
        
        for(int counter=0;counter<=50;counter++){
            magicNumbers.setHeight(counter);
        
            int calcC=magicNumbers.calculateC();
            if(calcC >=0 && calcC <=9){
                res=true;
            }
            else{
                res=false;
            }
            assertTrue("calculateC with height '"+ counter +"' should return between 0 and 9, but returned '"+calcC+"'", res);
        }
    }
    @Test
    public void VerifyCalculateDImplementation(){
        for(int counter=0;counter<=50;counter++){
            magicNumbers.setIncome(counter);
        
            int calcD=magicNumbers.calculateD();
            if(calcD >=0 && calcD <=9){
                res=true;
            }
            else{
                res=false;
            }
            assertTrue("calculateD with income '"+ counter +"' should return between 0 and 9, but returned '"+calcD+"'", res);
        }
        
    }
        
    @Test
    public void VerifyCalculateEImplementation(){
        magicNumbers.setAge(1);
        magicNumbers.setHeight(1);
        magicNumbers.setIncome(11);
        
        int calcE=magicNumbers.calculateE();
        
        // Testing at EF 11
        if(calcE >=0 && calcE <=9){
            res=true;
        }
        else{
            res=false;
        }
        assertTrue("calculateE with initial EF'11' should return between 0 and 9, but returned '"+calcE+"'", res);
        
        // Testing at EF 10
        magicNumbers.setIncome(10);        
        calcE=magicNumbers.calculateE();
        
        if(calcE >=0 && calcE <=9){
            res=true;
        }
        else{
            res=false;
        }
        assertTrue("calculateE with initial EF'10' should return between 0 and 9, but returned '"+calcE+"'", res);
        
        // Testing at EF 9.9
        magicNumbers.setIncome(3);        
        magicNumbers.setAge(11);
            
            calcE=magicNumbers.calculateE();

            if(calcE >=0 && calcE <=9){
                res=true;
            }
            else{
                res=false;
            }
            assertTrue("calculateE with An EF of 9.9 (using age '11' and income '3',height '1') should return between 0 and 9, but returned '"+calcE+"'", res);
        }
    
}
