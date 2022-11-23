package entities;

import entities.dndclasses.CharacterClass;
import entities.stats.Stats;

public class Character {
    private String name;
    private CharacterClass characterClass;
    private Stats attributes;

    public Character(String name, CharacterClass characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        attributes = Stats.generate();
    }

    public void addBonuses() {
        attributes.getStats().put(
                "constitution", (int) Math.round((characterClass.getHp() +
                        Math.floor(attributes.getStats()
                                .get("constitution") / 2d) - 5))
        );
    }

    public void talk(){
        System.out.printf("Hello, fellow traveler! My name is %s and my skills are: ", name);
        characterClass.printMagika();
        System.out.print("\nMy attributes are: \n");
        attributes.getStats().entrySet().forEach(System.out::println);
    }

    public String getName(){
        return name;
    }
}
