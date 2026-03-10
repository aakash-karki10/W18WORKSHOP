
/**
 * Write a description of class q4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;

public class Question4_JTableDisplay extends JFrame {
    public Question4_JTableDisplay() {
        setTitle("Student Records");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        // Step 1: Define column headers
        String[] columns = {"ID", "Name", "Age", "Department"};

        // Step 2: Define row data using 2D Object array
        Object[][] data = {
            {1, "Ram Sharma",   20, "CS"},
            {2, "Sita Thapa",   22, "IT"},
            {3, "Hari Karki",   21, "BCA"},
            {4, "Gita Shrestha", 19, "BBA"},
        };

        // Step 3: Create JTable with columns and data
        JTable table = new JTable(data, columns);

        // Step 4: Configure the table
        table.setRowHeight(30);                                           // Row height
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);     // Single row selection
        table.setDefaultEditor(Object.class, null);                      // Non-editable state

        // Step 5: Wrap in JScrollPane (required for headers to show)
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Step 6: Add a button to retrieve selected row
        JButton getBtn = new JButton("Get Selected Row");
        getBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow(); // retrieve selected row safely
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "No row selected!");
            } else {
                String name = table.getValueAt(selectedRow, 1).toString();
                JOptionPane.showMessageDialog(this, "Selected: " + name);
            }
        });
        add(getBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question4_JTableDisplay();
    }
}