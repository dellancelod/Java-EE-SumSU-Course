package entities;

import entities.dndclasses.CharacterClass;
import entities.races.CharacterRace;
import entities.stats.Stats;
import visitor.DataElement;
import visitor.DataElementVisitor;

import java.util.Map;

public class Character implements DataElement {

    private String name;
    private CharacterClass characterClass;
    private Stats stats;
    private CharacterRace race;

    public Character(String name, CharacterClass characterClass, Stats stats, CharacterRace race) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.stats = stats;
    }

    public void talk() {
        System.out.printf("Name: %s\nRace: %s\n", name, race.getName());
        race.saySMTH();
        System.out.println("Stats:");
        stats.getStats().entrySet().forEach(System.out::println);
    }

    @Override
    public void accept(DataElementVisitor visitor) {
        visitor.visit(this);
    }

    public String getName(){
        return name;
    }

    public CharacterRace getRace(){
        return race;
    }

    public CharacterClass getCharacterClass(){
        return characterClass;
    }

    public Stats getStats(){
        return stats;
    }
}