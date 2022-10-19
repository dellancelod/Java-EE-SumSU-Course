package Model;

import Model.MementoPattern.Memento;

public class Character {
    private String name;
    private String dndclass;
    private Stats attributes;

    public Character(String name, String dndclass){
        this.name = name;
        this.dndclass = dndclass;
        attributes = Stats.generate();
    }
    public void printSheet(){
        System.out.println("Name: " + name);
        System.out.println("Class: " + dndclass);
        attributes.print();
    }
    public void generateNewStats(){
        attributes = attributes.generate();
    }
    public Stats getAttributes() {
        return attributes;
    }

    public void loadAttributes(Memento memento){
        this.attributes.loadSavedState(memento);
    }
}
