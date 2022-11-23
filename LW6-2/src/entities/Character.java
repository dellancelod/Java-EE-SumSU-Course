package entities;

import entities.races.CharacterRace;
import entities.stats.Stats;

import java.util.Map;

public class Character {
    private String name;
    private CharacterRace race;
    private Stats stats;

    public Character(String name, CharacterRace race) {
        this.name = name;
        this.race = race;

        stats = Stats.generate();

        for(Map.Entry<String, Integer> stat : race.getBonuses().getStats().entrySet()){
            stats.getStats().put(stat.getKey(), stats.getStats().get(stat.getKey()) + stat.getValue());
        }
    }

    public void talk(){
        System.out.printf("Name: %s\nRace: %s\n", name, race.getName());
        race.saySMTH();
        System.out.println("Stats:");
        stats.getStats().entrySet().forEach(System.out::println);
    }
}
