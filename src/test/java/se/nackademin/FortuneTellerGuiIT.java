package se.nackademin;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.nackademin.gui.FortuneTellerGui;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

public class FortuneTellerGuiIT {
    FortuneTeller fortuneTeller;
    FortuneTellerGui fortuneTellerGui;

    @Test(timeout = 10000)
    public void testGetFortuneUsingGui() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("11000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String output = window.textBox("resultField").text();
        assertEquals("Verify that the fortune is calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }

    @Test(timeout = 10000)
    public void testInvalidIncome() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("hej");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String errorMessage = window.optionPane().label("OptionPane.label").text();
        assertThat("error message should contain text 'Invalid income'", errorMessage, containsString("Invalid income"));
        window.optionPane().button().click();
    }
    
    @Test(timeout = 10000)
    public void testFieldValidations(){
        String errorMessage;
        window.textBox("nameField").enterText("");
        window.button("calculateButton").click();
        
        errorMessage = window.optionPane().label("OptionPane.label").text();
        assertEquals("Name is not set correct","Invalid name!",errorMessage);
        
        window.optionPane().okButton().click();
        
        window.textBox("nameField").enterText("Kalle");
        window.textBox("incomeField").enterText("10000");
        
        // Now testing location
        window.textBox("locationField").enterText("");
        window.button("calculateButton").click();
        errorMessage = window.optionPane().label("OptionPane.label").text();
        assertEquals("Location is not set correct","Invalid location!",errorMessage);
        
        window.optionPane().okButton().click();
        window.textBox("locationField").enterText("Umeå");
        
        window.textBox("ageField").enterText("sdfgsdfg");
        window.button("calculateButton").click();
        errorMessage = window.optionPane().label("OptionPane.label").text();
        assertEquals("Age is not correct","Invalid age! Must not contain anything but numbers.",errorMessage);
        
        window.optionPane().okButton().click();
        
        window.textBox("ageField").setText("25");

        window.textBox("heightField").enterText("sdfgsdfg");
        window.button("calculateButton").click();
        errorMessage = window.optionPane().label("OptionPane.label").text();
        assertEquals("Height is not correct","Invalid height! Must not contain anything but numbers.",errorMessage);
        window.optionPane().okButton().click();
        
    }

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTellerGui = GuiActionRunner.execute(new GuiQuery<FortuneTellerGui>() {
            protected FortuneTellerGui executeInEDT() {
                return new FortuneTellerGui(fortuneTeller);
            }
        });
        window = new FrameFixture(fortuneTellerGui);
        window.show();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}

