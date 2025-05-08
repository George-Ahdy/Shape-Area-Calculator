package oop;
import java.util.ArrayList;
import java.util.Scanner;

class Input {
    final private String shape;
    final private double num;

    public Input(String shape, double num) {
        this.shape = shape;
        this.num = num;
    }

    public String getShape() {
        return shape;
    }

    public double getNum() {
        return num;
    }
}

public class DrawableTest {

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

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            DrawableTestGUI gui = new DrawableTestGUI();
           gui.showGUI();
            System.out.print("Enter the number of shapes: ");
            int numOfShapes = input.nextInt();
            input.nextLine();

            try {
                validateNumberOfShapes(numOfShapes);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            ArrayList<Input> inputs = new ArrayList<>();
            System.out.println("Enter shapes and values (e.g., circle 5 cube 3):");
            String info = input.nextLine();
            String[] parts = info.split(" ");

            if (parts.length % 2 != 0) {
                System.out.println("Error: Each shape must be followed by a value.");
                return;
            }

            for (int i = 0; i < parts.length; i += 2) {
                String shape = parts[i];
                String value = parts[i + 1];
                try {
                    validateShape(shape);
                    validateInputValue(value);
                    double num = Double.parseDouble(value);
                    inputs.add(new Input(shape, num));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

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

            System.out.println("The sum of all the Drawable array areas is: " + totalArea);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}