package ru.mirea.fedoseev.practice8;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Task3ImageDisplay extends JFrame {
    private BufferedImage image;

    public Task3ImageDisplay(String imagePath) {
        setTitle("Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            image = ImageIO.read(new File(imagePath));
            if (image == null) {
                JOptionPane.showMessageDialog(this,
                        "Unable to load image: " + imagePath,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

            setSize(image.getWidth() + 20, image.getHeight() + 40);
            setLocationRelativeTo(null);

            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (image != null) {
                        g.drawImage(image, 0, 0, this);
                    }
                }

                @Override
                public Dimension getPreferredSize() {
                    if (image != null) {
                        return new Dimension(image.getWidth(), image.getHeight());
                    }
                    return super.getPreferredSize();
                }
            };

            add(imagePanel);
            setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading image: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java Task3ImageDisplay <image_path>");
            System.err.println("Example: java Task3ImageDisplay /path/to/image.jpg");
            System.exit(1);
        }

        String imagePath = args[0];
        SwingUtilities.invokeLater(() -> new Task3ImageDisplay(imagePath));
    }
}
