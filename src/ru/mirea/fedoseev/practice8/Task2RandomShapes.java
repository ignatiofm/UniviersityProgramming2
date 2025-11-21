package ru.mirea.fedoseev.practice8;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2RandomShapes extends JFrame {
    private List<Shape> shapes;

    public Task2RandomShapes() {
        setTitle("Random Shapes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        shapes = new ArrayList<>();
        generateRandomShapes();

        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape shape : shapes) {
                    shape.draw(g);
                }
            }
        };

        add(drawPanel);
        setVisible(true);
    }

    private void generateRandomShapes() {
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            Color randomColor = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            );

            int x = random.nextInt(700);
            int y = random.nextInt(500);

            int shapeType = random.nextInt(3);

            switch (shapeType) {
                case 0:
                    int radius = 20 + random.nextInt(50);
                    shapes.add(new Circle(randomColor, x, y, radius));
                    break;
                case 1:
                    int width = 30 + random.nextInt(70);
                    int height = 30 + random.nextInt(70);
                    shapes.add(new Rectangle(randomColor, x, y, width, height));
                    break;
                case 2:
                    int triWidth = 30 + random.nextInt(70);
                    int triHeight = 30 + random.nextInt(70);
                    shapes.add(new Triangle(randomColor, x, y, triWidth, triHeight));
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Task2RandomShapes());
    }
}
