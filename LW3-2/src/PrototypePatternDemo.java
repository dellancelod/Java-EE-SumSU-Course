public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        var clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape: " + clonedShape.getType() + "/" + clonedShape.hashCode());

        clonedShape = ShapeCache.getShape("2");
        System.out.println("Shape: " + clonedShape.getType());

        clonedShape = ShapeCache.getShape("3");
        System.out.println("Shape: " + clonedShape.getType());
    }
}