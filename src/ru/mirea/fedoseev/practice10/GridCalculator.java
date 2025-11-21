package ru.mirea.fedoseev.practice10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridCalculator extends JFrame {
    private JTextField displayField;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public GridCalculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Поле отображения
        displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        // Панель с кнопками
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Массив кнопок
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "", "", ""
        };

        // Создаем и добавляем кнопки
        for (String text : buttons) {
            if (text.isEmpty()) {
                buttonPanel.add(new JLabel()); // Пустое место
                continue;
            }

            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
                // Цифры и точка
                if (startNewNumber) {
                    displayField.setText(command);
                    startNewNumber = false;
                } else {
                    displayField.setText(displayField.getText() + command);
                }
            } else if (command.equals("C")) {
                // Очистка
                displayField.setText("0");
                firstNumber = 0;
                operator = "";
                startNewNumber = true;
            } else if (command.equals("=")) {
                // Вычисление результата
                if (!operator.isEmpty()) {
                    double secondNumber = Double.parseDouble(displayField.getText());
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            if (secondNumber != 0) {
                                result = firstNumber / secondNumber;
                            } else {
                                JOptionPane.showMessageDialog(GridCalculator.this,
                                        "Error: Division by zero!",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                displayField.setText("0");
                                firstNumber = 0;
                                operator = "";
                                startNewNumber = true;
                                return;
                            }
                            break;
                    }

                    // Форматируем результат
                    if (result == (long) result) {
                        displayField.setText(String.valueOf((long) result));
                    } else {
                        displayField.setText(String.valueOf(result));
                    }

                    firstNumber = result;
                    operator = "";
                    startNewNumber = true;
                }
            } else {
                // Операторы +, -, *, /
                if (!operator.isEmpty() && !startNewNumber) {
                    // Если уже есть оператор, сначала вычисляем предыдущую операцию
                    double secondNumber = Double.parseDouble(displayField.getText());
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            if (secondNumber != 0) {
                                result = firstNumber / secondNumber;
                            } else {
                                JOptionPane.showMessageDialog(GridCalculator.this,
                                        "Error: Division by zero!",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                displayField.setText("0");
                                firstNumber = 0;
                                operator = "";
                                startNewNumber = true;
                                return;
                            }
                            break;
                    }

                    firstNumber = result;
                    if (result == (long) result) {
                        displayField.setText(String.valueOf((long) result));
                    } else {
                        displayField.setText(String.valueOf(result));
                    }
                } else {
                    firstNumber = Double.parseDouble(displayField.getText());
                }

                operator = command;
                startNewNumber = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridCalculator();
            }
        });
    }
}
