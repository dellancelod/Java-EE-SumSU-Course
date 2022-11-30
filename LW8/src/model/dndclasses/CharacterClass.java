package model.dndclasses;


public abstract class CharacterClass {
    protected String name;
    protected int hp;

    public abstract void printMagika();
    @Override
    public abstract String toString();
    public abstract String getName();
    public abstract int getHp();
}