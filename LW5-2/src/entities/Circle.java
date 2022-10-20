package entities;

public class Circle extends Shape{
    int centerPointX, centerPointY;
    @Override
    void setCoordinates(int x, int y) {
        centerPointX = x;
        centerPointY = y;
        System.out.printf("\nCenter of circle is set as (%d, %d)\n", centerPointX, centerPointY);
    }

    @Override
    void drawShape() {
        System.out.println("Circle has been drawn");
    }

    @Override
    void paintShape() {
        System.out.println("Circle has been painted");
    }
}
