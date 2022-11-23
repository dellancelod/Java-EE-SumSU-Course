package entities.races;

import entities.stats.Stats;
import visitor.DataElement;

public abstract class CharacterRace implements DataElement {

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