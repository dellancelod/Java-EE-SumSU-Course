package entities.races;

import entities.stats.Stats;
import visitor.DataElementVisitor;

public class Goblin extends CharacterRace{
    public Goblin(){
        name = "Goblin";
        bonuses = new Stats(2,1,0,0,0,0);
    }

    @Override
    public void saySMTH() {
        System.out.println("Empty your pockets now!");
    }

    @Override
    public void accept(DataElementVisitor visitor) {
        visitor.visit(this);
    }
}
