package oop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class DrawableTestGUI extends JFrame {
    final private JTextField numOfShapesField;
    final private JButton submitButton;
    final private JTextArea shapesArea;
    final private ArrayList<Input> inputs;

    public DrawableTestGUI() {
        setTitle("Drawable Test");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        numOfShapesField = new JTextField(10);
        submitButton = new JButton("Submit");
        shapesArea = new JTextArea(10, 30);
        shapesArea.setEditable(false);

        add(new JLabel("Enter number of shapes:"));
        add(numOfShapesField);
        add(submitButton);
        add(new JScrollPane(shapesArea));

        inputs = new ArrayList<>();

        submitButton.addActionListener((ActionEvent e) -> {
            handleNumberOfShapes();
        });
    }

    private void handleNumberOfShapes() {
        String numOfShapesText = numOfShapesField.getText();
        try {
            int numOfShapes = Integer.parseInt(numOfShapesText);
            validateNumberOfShapes(numOfShapes);
            shapesArea.append("Number of shapes: " + numOfShapes + "\n");
            promptForShapes(numOfShapes);
        } catch (NumberFormatException ex) {
            shapesArea.append("Invalid number format!\n");
        } catch (IllegalArgumentException ex) {
            shapesArea.append(ex.getMessage() + "\n");
        }
    }

    private void promptForShapes(int numOfShapes) {
        for (int i = 0; i < numOfShapes; i++) {
            String shape = JOptionPane.showInputDialog(this, "Enter shape (circle/cube):");
            if (shape == null) return;

            try {
                validateShape(shape);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Invalid shape! Please enter 'circle' or 'cube'.", "Error", JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }

            String value = JOptionPane.showInputDialog(this, "Enter value:");
            if (value == null) return;

            try {
                validateInputValue(value);
                double num = Double.parseDouble(value);
                inputs.add(new Input(shape, num));
                shapesArea.append("Shape: " + shape + ", Value: " + num + "\n");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Invalid value! Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                i--;
            }
        }

        calculateTotalArea();
    }

    private void calculateTotalArea() {
        double totalArea = 0;
        for (Input inputShape : inputs) {
            if (inputShape.getShape().equalsIgnoreCase("circle")) {
                Circle circle = new Circle(inputShape.getNum());
                totalArea += circle.getArea();
            } else if (inputShape.getShape().equalsIgnoreCase("cube")) {
                Cube cube = new Cube(inputShape.getNum());
                totalArea += cube.getArea();
            }
        }
        shapesArea.append("The sum of all the Drawable array areas is: " + totalArea + "\n");
    }

    public void showGUI() {
        setVisible(true);
    }

    public static void main(String[] args) {
        DrawableTestGUI gui = new DrawableTestGUI();
        gui.showGUI();
    }

    // Validation methods
    public static boolean isDouble(String str) {
        return str.matches("\\d+(\\.\\d+)?");
    }

    public static void validateNumberOfShapes(int n) throws IllegalArgumentException {
        if (n < 2) {
            throw new IllegalArgumentException("The number of drawable tests must be greater than or equal to two!");
        }
    }

    public static void validateInputValue(String str) throws IllegalArgumentException {
        if (!isDouble(str)) {
            throw new IllegalArgumentException("Invalid input value!");
        }
    }

    public static void validateShape(String str) throws IllegalArgumentException {
        if (!str.equalsIgnoreCase("circle") && !str.equalsIgnoreCase("cube")) {
            throw new IllegalArgumentException("Invalid Shape!");
        }
    }
}