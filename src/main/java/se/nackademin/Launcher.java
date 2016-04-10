package se.nackademin;

import se.nackademin.gui.FortuneTellerGui;

public class Launcher {
    public static void main(String[] args) {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        FortuneTellerGui fortuneTellerGui = new FortuneTellerGui(fortuneTeller);
        fortuneTellerGui.setVisible(true);
    }
}
