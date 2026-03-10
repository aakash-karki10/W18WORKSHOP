
/**
 * Write a description of class q1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;

public class Question1_ComponentSelection extends JFrame {
    public Question1_ComponentSelection() {
        setTitle("Student Registration Form");
        setLayout(new GridLayout(6, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Student Name, Age, Phone - use JTextField (free text input)
        add(new JLabel("Student Name:"));
        add(new JTextField()); // JTextField for free text

        add(new JLabel("Age:"));
        add(new JTextField()); // JTextField for numeric input

        add(new JLabel("Phone Number:"));
        add(new JTextField()); // JTextField for phone number

        // 2. Department - 12 options → use JComboBox (5+ options)
        add(new JLabel("Department:"));
        String[] departments = {"CS", "IT", "BBA", "BCA", "Civil", "Mechanical",
                                "Electrical", "Architecture", "Law", "Medicine", "Arts", "Science"};
        add(new JComboBox<>(departments)); // JComboBox for 5+ predefined options

        // 3. Gender - 3 options (Male/Female/Other) → use JRadioButton (2-4 options)
        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        ButtonGroup bg = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");
        bg.add(male); bg.add(female); bg.add(other);
        genderPanel.add(male); genderPanel.add(female); genderPanel.add(other);
        add(genderPanel); // JRadioButton for 2-4 options (only one can be selected)

        // 4. Hobbies - multiple selections allowed → use JCheckBox
        add(new JLabel("Hobbies:"));
        JPanel hobbiesPanel = new JPanel();
        hobbiesPanel.add(new JCheckBox("Reading"));  // JCheckBox allows multiple selection
        hobbiesPanel.add(new JCheckBox("Gaming"));
        hobbiesPanel.add(new JCheckBox("Cooking"));
        add(hobbiesPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question1_ComponentSelection();
    }
}

/*
WHY these components?
- JTextField  → free text/numbers, no predefined options
- JComboBox   → 5+ predefined options, saves space (dropdown)
- JRadioButton→ 2-4 options, only ONE can be selected at a time
- JCheckBox   → multiple selections allowed simultaneously
*/