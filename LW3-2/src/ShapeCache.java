import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId){
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }
    public static void loadCache(){
        var circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        var square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        var rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
