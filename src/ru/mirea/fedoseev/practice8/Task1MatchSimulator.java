package ru.mirea.fedoseev.practice8;

import javax.swing.*;
import java.awt.*;

public class Task1MatchSimulator extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public Task1MatchSimulator() {
        setTitle("Match Simulator: AC Milan vs Real Madrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Top panel with buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        milanButton.setFont(new Font("Arial", Font.BOLD, 16));
        madridButton.setFont(new Font("Arial", Font.BOLD, 16));

        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Center panel with labels
        JPanel labelPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lastScorerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 18));

        labelPanel.add(resultLabel);
        labelPanel.add(lastScorerLabel);
        labelPanel.add(winnerLabel);
        labelPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add action listeners
        milanButton.addActionListener(e -> {
            milanScore++;
            updateLabels("AC Milan");
        });

        madridButton.addActionListener(e -> {
            madridScore++;
            updateLabels("Real Madrid");
        });

        // Add panels to frame
        add(buttonPanel, BorderLayout.NORTH);
        add(labelPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void updateLabels(String lastScorer) {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Task1MatchSimulator());
    }
}
