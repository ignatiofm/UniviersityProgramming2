package ru.mirea.fedoseev.practice10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcTwoFields extends JFrame {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;

    public SimpleCalcTwoFields() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 150);

        // Первое поле
        JLabel firstLabel = new JLabel("1st Number");
        add(firstLabel);

        firstNumberField = new JTextField(10);
        add(firstNumberField);

        // Второе поле
        JLabel secondLabel = new JLabel("2nd Number");
        add(secondLabel);

        secondNumberField = new JTextField(10);
        add(secondNumberField);

        // Кнопки операций
        addButton = new JButton("Add");
        subButton = new JButton("Sub");
        mulButton = new JButton("Mul");
        divButton = new JButton("Div");

        // Обработчики событий
        addButton.addActionListener(new OperationListener());
        subButton.addActionListener(new OperationListener());
        mulButton.addActionListener(new OperationListener());
        divButton.addActionListener(new OperationListener());

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(firstNumberField.getText());
                double num2 = Double.parseDouble(secondNumberField.getText());
                double result = 0;
                String operation = "";

                if (e.getSource() == addButton) {
                    result = num1 + num2;
                    operation = "Addition";
                } else if (e.getSource() == subButton) {
                    result = num1 - num2;
                    operation = "Subtraction";
                } else if (e.getSource() == mulButton) {
                    result = num1 * num2;
                    operation = "Multiplication";
                } else if (e.getSource() == divButton) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(SimpleCalcTwoFields.this,
                                "Error: Division by zero!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                    operation = "Division";
                }

                JOptionPane.showMessageDialog(SimpleCalcTwoFields.this,
                        operation + " result: " + result,
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(SimpleCalcTwoFields.this,
                        "Error: Please enter valid numbers!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalcTwoFields();
            }
        });
    }
}
