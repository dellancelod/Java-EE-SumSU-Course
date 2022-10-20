package shapes;

import drawing.DrawInterface;

public class Circle extends Shape {

    private int x;
    private int y;
    private int radius;

    public Circle(DrawInterface drawable, int x, int y, int radius) {
        super(drawable);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawable.drawCircle(radius, x, y);
    }
}
