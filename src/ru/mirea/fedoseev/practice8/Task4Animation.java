package ru.mirea.fedoseev.practice8;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Task4Animation extends JFrame {
    private BufferedImage[] frames;
    private int currentFrame = 0;
    private Timer timer;

    public Task4Animation() {
        setTitle("Animation Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create animation frames
        createFrames();

        JPanel animationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (frames != null && frames.length > 0) {
                    g.drawImage(frames[currentFrame], 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        add(animationPanel);

        // Timer for animation
        timer = new Timer(100, e -> {
            currentFrame = (currentFrame + 1) % frames.length;
            animationPanel.repaint();
        });
        timer.start();

        setVisible(true);
    }

    private void createFrames() {
        int frameCount = 10;
        frames = new BufferedImage[frameCount];
        int width = 600;
        int height = 400;

        for (int i = 0; i < frameCount; i++) {
            frames[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = frames[i].createGraphics();

            // Background
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);

            // Draw animated circle
            int x = (int) (50 + (width - 150) * ((double) i / frameCount));
            int y = height / 2 - 30;

            // Change color based on frame
            float hue = (float) i / frameCount;
            g2d.setColor(Color.getHSBColor(hue, 1.0f, 1.0f));
            g2d.fillOval(x, y, 60, 60);

            // Draw frame number
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("Frame: " + (i + 1) + "/" + frameCount, 20, 30);

            // Draw trail effect
            g2d.setColor(new Color(200, 200, 200, 100));
            for (int j = 0; j < i; j++) {
                int trailX = (int) (50 + (width - 150) * ((double) j / frameCount));
                int trailY = height / 2 - 30;
                g2d.fillOval(trailX + 20, trailY + 20, 20, 20);
            }

            g2d.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Task4Animation());
    }
}
