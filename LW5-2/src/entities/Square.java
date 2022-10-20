package entities;

public class Square extends Shape{
    int leftBottomX, leftBottomY;
    @Override
    void setCoordinates(int x, int y) {
        System.out.printf("\nLeft bottom corner of rectangle set as (%d, %d)\n", leftBottomX, leftBottomY);
    }

    @Override
    void drawShape() {
        System.out.println("Square has been drawn");
    }

    @Override
    void paintShape() {
        System.out.println("Square has been painted");
    }
}
