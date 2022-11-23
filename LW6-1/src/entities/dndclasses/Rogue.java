package entities.dndclasses;

public class Rogue extends CharacterClass{
    private String perk;

    public Rogue() {
        name = "Rogue";
        hp = 8;
        perk = "Sneak Attack";
    }

    @Override
    public void printMagika() {
        System.out.print(perk);
    }

    @Override
    public String toString() {
        return "Class: " + name + "\n" +
                "Health points: " + hp + "\n" +
                "Perk: " + perk;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }
}
