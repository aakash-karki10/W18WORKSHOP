
/**
 * Write a description of class q6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;

public class Question6_Accessibility extends JFrame {
    public Question6_Accessibility() {
        setTitle("Accessibility Demo");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameField = new JTextField(15);
        JButton saveBtn  = new JButton("Save");
        JButton clearBtn = new JButton("Clear");

        // 1. setMnemonic() - keyboard shortcut using Alt + key
        //    Alt+S triggers Save button, Alt+C triggers Clear button
        saveBtn.setMnemonic('S');   // keyboard users press Alt+S to click Save
        clearBtn.setMnemonic('C');  // keyboard users press Alt+C to click Clear

        // 2. setToolTipText() - shows helpful hint when mouse hovers
        nameField.setToolTipText("Enter your full name here");
        saveBtn.setToolTipText("Save the form data (Alt+S)");
        clearBtn.setToolTipText("Clear all fields (Alt+C)");

        // 3. setAccessibleDescription() - for screen readers
        saveBtn.getAccessibleContext().setAccessibleDescription("Saves student record to database");

        saveBtn.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Saved! Name: " + nameField.getText()));
        clearBtn.addActionListener(e -> nameField.setText(""));

        add(new JLabel("Name:"));
        add(nameField);
        add(saveBtn);
        add(clearBtn);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question6_Accessibility();
    }
}