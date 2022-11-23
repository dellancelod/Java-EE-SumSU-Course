package entities.races;

import entities.stats.Stats;

public abstract class CharacterRace {

    protected String name;

    protected Stats bonuses;

    public abstract void saySMTH();

    public String getName(){
        return name;
    }

    public Stats getBonuses(){
        return bonuses;
    }
}