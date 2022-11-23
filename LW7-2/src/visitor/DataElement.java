package visitor;

public interface DataElement {

    void accept(DataElementVisitor visitor);

}