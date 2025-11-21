package ru.mirea.fedoseev.practice10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWithTextApp extends JFrame {
    private JTextArea textArea;
    private String clipboard = "";

    public MenuWithTextApp() {
        setTitle("Menu Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Создание меню-бара
        JMenuBar menuBar = new JMenuBar();

        // Меню File
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuWithTextApp.this,
                        "Saving is not implemented",
                        "Save",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Меню Edit
        JMenu editMenu = new JMenu("Edit");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");

        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = textArea.getSelectedText();
                if (selectedText != null) {
                    clipboard = selectedText;
                    JOptionPane.showMessageDialog(MenuWithTextApp.this,
                            "Text copied to clipboard",
                            "Copy",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        cutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = textArea.getSelectedText();
                if (selectedText != null) {
                    clipboard = selectedText;
                    textArea.replaceSelection("");
                    JOptionPane.showMessageDialog(MenuWithTextApp.this,
                            "Text cut to clipboard",
                            "Cut",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clipboard.isEmpty()) {
                    int caretPosition = textArea.getCaretPosition();
                    textArea.insert(clipboard, caretPosition);
                }
            }
        });

        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        // Меню Help
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuWithTextApp.this,
                        "Menu Application\nVersion 1.0\n\nA simple text editor with menu bar and buttons.",
                        "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        helpMenu.add(aboutItem);

        // Добавляем меню в меню-бар
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Панель с кнопками
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("\nButton 1 was clicked!");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("\nButton 2 was clicked!");
            }
        });

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // Текстовая область
        textArea = new JTextArea("This is the area you can write text.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setMargin(new Insets(5, 5, 5, 5));

        JScrollPane scrollPane = new JScrollPane(textArea);

        // Добавляем компоненты в окно
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuWithTextApp();
            }
        });
    }
}
