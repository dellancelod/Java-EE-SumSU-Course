package entities.races;

import entities.stats.Stats;

public class LightfootHalfling extends CharacterRace{
    public LightfootHalfling(){
        name = "Halfling (Lightfoot)";
        bonuses = new Stats(2,0,0,0,0,1);
    }

    @Override
    public void saySMTH() {
        System.out.println("Yes, I'm half of your height. So what?");
    }
}
