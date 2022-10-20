import drawing.GreenCircle;
import drawing.RedCircle;
import shapes.Circle;
import shapes.Shape;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 12, 10, 10);
        Shape greenCircle = new Circle(new GreenCircle(), 12, 12, 20);

        redCircle.draw();
        greenCircle.draw();
    }
}