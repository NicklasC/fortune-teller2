package se.nackademin.gui;

import se.nackademin.FortuneTeller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FortuneTellerGui extends JFrame implements ActionListener {

    private static final String NAME_LABEL = "Name:";
    private static final String INCOME_LABEL = "Income (monthly):";
    private static final String LOCATION_LABEL = "Location:";
    private static final String AGE_LABEL = "Age:";
    private static final String HEIGHT_LABEL = "Height:";
    private static final String FORTUNE_LABEL = "Your fortune:";
    private static final String BUTTON_TEXT = "Calculate";
    private final FortuneTeller fortuneTeller;
    private final JTextField nameField = new JTextField();
    private final JTextField incomeField = new JTextField();
    private final JTextField locationField = new JTextField();
    private final JTextField ageField = new JTextField();
    private final JTextField heightField = new JTextField();
    private final JTextArea resultField = new JTextArea();
    private final JButton calculateButton = new JButton(BUTTON_TEXT);
    private final JPanel mainPanel = new JPanel();

    public FortuneTellerGui(FortuneTeller fortuneTeller) {
        this.fortuneTeller = fortuneTeller;
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        mainPanel.setLayout(new GridLayout(13, 0));
        mainPanel.add(new JLabel(NAME_LABEL));
        mainPanel.add(nameField);
        nameField.setName("nameField");
        mainPanel.add(new JLabel(INCOME_LABEL));
        mainPanel.add(incomeField);
        incomeField.setName("incomeField");
        mainPanel.add(new JLabel(LOCATION_LABEL));
        mainPanel.add(locationField);
        locationField.setName("locationField");
        mainPanel.add(new JLabel(AGE_LABEL));
        mainPanel.add(ageField);
        ageField.setName("ageField");
        mainPanel.add(new JLabel(HEIGHT_LABEL));
        mainPanel.add(heightField);
        heightField.setName("heightField");
        mainPanel.add(calculateButton);
        calculateButton.setName("calculateButton");
        mainPanel.add(new JLabel(FORTUNE_LABEL));
        mainPanel.add(resultField);
        resultField.setName("resultField");
        getContentPane().add(mainPanel);
        calculateButton.addActionListener(this);
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(this, message, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            boolean valid = true;
            if (!fortuneTeller.setName(nameField.getText())) {
                valid = false;
                alert("Invalid name!");
            } else if (!fortuneTeller.setIncome(incomeField.getText())) {
                valid = false;
                alert("Invalid income! Must not contain anything but numbers.");
            } else if (!fortuneTeller.setLocation(locationField.getText())) {
                valid = false;
                alert("Invalid location!");
            } else if (!fortuneTeller.setAge(ageField.getText())) {
                valid = false;
                alert("Invalid age! Must not contain anything but numbers.");
            } else if (!fortuneTeller.setHeight(heightField.getText())) {
                valid = false;
                alert("Invalid height! Must not contain anything but numbers.");
            }
            if (valid) {
                resultField.setText(fortuneTeller.calculate());
            }
        }
    }
}
