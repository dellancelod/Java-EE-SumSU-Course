package entities;

public class Rectangle extends Shape{
    int leftBottomX, leftBottomY;
    @Override
    void setCoordinates(int x, int y) {
        leftBottomX = x;
        leftBottomY = y;
        System.out.printf("\nLeft bottom corner of rectangle set as (%d, %d)\n", leftBottomX, leftBottomY);
    }

    @Override
    void drawShape() {
        System.out.println("Rectangle has been drawn");
    }

    @Override
    void paintShape() {
        System.out.println("Rectangle has been painted");
    }
}
