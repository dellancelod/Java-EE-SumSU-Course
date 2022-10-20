package drawing;

public class RedCircle implements DrawInterface{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.printf("Circle (radius: %d, x: %d, y: %d, color: red)\n", radius, x, y);
    }
}
