
/**
 * Write a description of class q3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Question3_ButtonStateManagement extends JFrame {
    JTextField nameField, ageField;
    JButton submitBtn;

    public Question3_ButtonStateManagement() {
        setTitle("State Management");
        setLayout(new GridLayout(3, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        submitBtn = new JButton("Submit");
        submitBtn.setEnabled(false); // DISABLED by default when form opens
        add(submitBtn);

        // Listen for changes in both fields
        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e)  { checkFields(); }
            public void removeUpdate(DocumentEvent e)  { checkFields(); }
            public void changedUpdate(DocumentEvent e) { checkFields(); }
        };

        nameField.getDocument().addDocumentListener(listener);
        ageField.getDocument().addDocumentListener(listener);

        pack();
        setVisible(true);
    }

    // Enable Submit only when BOTH fields are filled
    private void checkFields() {
        boolean nameOk = !nameField.getText().trim().isEmpty();
        boolean ageOk  = !ageField.getText().trim().isEmpty();
        submitBtn.setEnabled(nameOk && ageOk); // enabled only if both filled
    }

    public static void main(String[] args) {
        new Question3_ButtonStateManagement();
    }
}