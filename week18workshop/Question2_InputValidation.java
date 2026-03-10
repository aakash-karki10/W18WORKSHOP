
/**
 * Write a description of class q2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question2_InputValidation extends JFrame {
    JTextField nameField, ageField, phoneField;
    JLabel errorLabel;

    public Question2_InputValidation() {
        setTitle("Validation Form");
        setLayout(new GridLayout(5, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        JButton submitBtn = new JButton("Submit");
        add(submitBtn);

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        add(errorLabel);

        submitBtn.addActionListener(e -> validateInputs());

        pack();
        setVisible(true);
    }

    private void validateInputs() {
        String name  = nameField.getText().trim();
        String age   = ageField.getText().trim();
        String phone = phoneField.getText().trim();

        // 1. Presence check (empty fields)
        if (name.isEmpty()) {
            errorLabel.setText("Name cannot be empty!");
            nameField.setBackground(Color.PINK); // UI highlights the error field
            return;
        }

        // 2. Type check (age must be numeric)
        int ageValue;
        try {
            ageValue = Integer.parseInt(age);
        } catch (NumberFormatException ex) {
            errorLabel.setText("Age must be a number!");
            ageField.setBackground(Color.PINK);
            return;
        }

        // 3. Range check (valid age: 1 to 120)
        if (ageValue < 1 || ageValue > 120) {
            errorLabel.setText("Age must be between 1 and 120!");
            ageField.setBackground(Color.PINK);
            return;
        }

        // 4. Format check (phone: digits only, 10 characters)
        if (!phone.matches("\\d{10}")) {
            errorLabel.setText("Phone must be 10 digits only!");
            phoneField.setBackground(Color.PINK);
            return;
        }

        // All valid
        errorLabel.setForeground(Color.GREEN);
        errorLabel.setText("All inputs are valid!");
        nameField.setBackground(Color.WHITE);
        ageField.setBackground(Color.WHITE);
        phoneField.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new Question2_InputValidation();
    }
}