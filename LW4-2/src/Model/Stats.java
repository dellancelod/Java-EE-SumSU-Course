package Model;

import Model.MementoPattern.Memento;

public class Stats {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public static Stats generate(){
        return new Stats(
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat(),
                Dice.rollStat());
    }
    private Stats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public void loadSavedState(Memento memento) {
        Stats savedState = memento.getStats();
        strength = savedState.strength;
        dexterity = savedState.dexterity;
        constitution = savedState.constitution;
        intelligence = savedState.intelligence;
        wisdom = savedState.wisdom;
        charisma = savedState.charisma;
    }
    public Memento save() {
        return new Memento(this);
    }
    public void print(){
        System.out.println("~~~~~Stats ~~~~~\n" +
                "strength: " + strength + "\n" +
                "dexterity: " + dexterity + "\n" +
                "constitution: " + constitution + "\n" +
                "intelligence: " + intelligence + "\n" +
                "wisdom: " + wisdom + "\n" +
                "charisma: " + charisma);
    }
}
