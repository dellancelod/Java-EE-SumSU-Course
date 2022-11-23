package entities.dndclasses;

import visitor.DataElement;

public abstract class CharacterClass implements DataElement {
    protected String name;
    protected int hp;

    public abstract void printMagika();
    @Override
    public abstract String toString();
    public abstract String getName();
    public abstract int getHp();
}