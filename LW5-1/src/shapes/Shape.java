package shapes;

import drawing.DrawInterface;

public abstract class Shape {
    protected DrawInterface drawable;

    public Shape(DrawInterface drawable) {
        this.drawable = drawable;
    }

    public abstract void draw();
}
