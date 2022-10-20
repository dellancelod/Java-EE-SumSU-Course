import entities.ShapeDrawer;

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeDrawer shapeDrawer = new ShapeDrawer();

        shapeDrawer.drawCircle();
        System.out.println();

        shapeDrawer.drawSquare();
        System.out.println();

        shapeDrawer.drawRectangle();
    }
}