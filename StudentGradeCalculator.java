import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class StudentGradeCalculator extends JFrame implements ActionListener{
    JLabel nameLabel, marksLabel, resultLabel, gradeLabel;
    JTextField nameField, marksField;
    JButton calcButton, clearButton;

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        nameLabel = new JLabel("Student Name:");
        marksLabel = new JLabel("Marks (out of 100):");
        resultLabel = new JLabel("Result:");
        gradeLabel = new JLabel("Grade:");

        nameField = new JTextField();
        marksField = new JTextField();

        calcButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        add(nameLabel);
        add(nameField);
        add(marksLabel);
        add(marksField);
        add(calcButton);
        add(clearButton);
        add(resultLabel);
        add(new JLabel(""));
        add(gradeLabel);
        add(new JLabel(""));

        calcButton.addActionListener(this);
        clearButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcButton) {
            try {
                String name = nameField.getText();
                double marks = Double.parseDouble(marksField.getText());
                String grade, result;

                if (marks >= 90) grade = "A+";
                else if (marks >= 80) grade = "A";
                else if (marks >= 70) grade = "B";
                else if (marks >= 60) grade = "C";
                else if (marks >= 50) grade = "D";
                else grade = "F";

                if (marks >= 50) result = "Pass";
                else result = "Fail";

                resultLabel.setText("Result: " + name + " - " + result);
                gradeLabel.setText("Grade: " + grade);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid marks!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            marksField.setText("");
            resultLabel.setText("Result:");
            gradeLabel.setText("Grade:");
        }
    }

    
    public static void main(String args[]){
        new StudentGradeCalculator();
    }
    
}
