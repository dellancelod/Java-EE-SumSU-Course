package entities;

public class Rectangle extends Shape{
    private String type;

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}
