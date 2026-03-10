
/**
 * Write a description of class q5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;

public class Question5_JScrollPane extends JFrame {
    public Question5_JScrollPane() {
        setTitle("JScrollPane Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200); // Small window to show scrolling

        String[] columns = {"ID", "Name", "Age"};

        // Many rows to demonstrate scrolling
        Object[][] data = new Object[20][3];
        for (int i = 0; i < 20; i++) {
            data[i][0] = i + 1;
            data[i][1] = "Student " + (i + 1);
            data[i][2] = 18 + (i % 5);
        }

        JTable table = new JTable(data, columns);
        table.setDefaultEditor(Object.class, null); // non-editable

        // WITHOUT JScrollPane: only first few rows visible, NO headers shown
        // add(table); // ← BAD - don't do this

        // WITH JScrollPane: headers appear, vertical/horizontal scrolling works
        JScrollPane scrollPane = new JScrollPane(table); // ← CORRECT
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question5_JScrollPane();
    }
}