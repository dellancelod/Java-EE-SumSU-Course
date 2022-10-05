package entities;

public abstract class Shape implements Cloneable{
    private String id;
    public String type;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Object clone() {
        Object cloneObject = null;

        try {
            cloneObject = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        return cloneObject;
    }
}
