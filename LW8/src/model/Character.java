package model;

import model.dndclasses.CharacterClass;
import model.races.CharacterRace;
import model.stats.Stats;

public class Character {

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