abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

   
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

   
    public double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("Circle Area: " + shape.calculateArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("Rectangle Area: " + shape.calculateArea());
            } else if (shape instanceof Triangle) {
                System.out.println("Triangle Area: " + shape.calculateArea());
            }
        }
    }
}