package entities;

public class ShapeDrawer {
    public Shape drawCircle() {
        Shape circle = new Circle();
        circle.setCoordinates(1,1);
        circle.drawShape();
        circle.paintShape();
        return circle;
    }

    public Shape drawSquare() {
        Shape square = new Square();
        square.setCoordinates(10,10);
        square.drawShape();
        square.paintShape();
        return square;
    }

    public Shape drawRectangle() {
        Shape rectangle = new Rectangle();
        rectangle.setCoordinates(-10,-10);
        rectangle.drawShape();
        rectangle.paintShape();
        return rectangle;
    }
}
