package entities.dndclasses;

import visitor.DataElementVisitor;

import java.util.List;

public class Paladin extends CharacterClass {

    private List<String> spells;

    public Paladin() {
        name = "Paladin";
        hp = 10;
        spells = List.of("Bless", "Aura of Life");
    }


    @Override
    public void printMagika() {
        System.out.print(String.join(",", spells));
    }

    @Override
    public String toString() {
        return "Class: " + name + "\n" +
                "Health points: " + hp + "\n" +
                "Spells: " + String.join(String.join(",", spells));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void accept(DataElementVisitor visitor) {
        visitor.visit(this);
    }
}
