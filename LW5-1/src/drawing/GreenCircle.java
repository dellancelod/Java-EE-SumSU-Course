package drawing;

public class GreenCircle implements DrawInterface{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.printf("Circle (radius: %d, x: %d, y: %d, color: green)\n", radius, x, y);
    }
}
