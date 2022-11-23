import entities.factories.GoblinFactory;
import entities.factories.LightfootHalflingFactory;
import entities.factories.RaceAbstractFactory;
import entities.Character;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        RaceAbstractFactory raceFactory = new LightfootHalflingFactory();

        Character character = new Character("Player 1", raceFactory.create());
        character.talk();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");

        raceFactory = new GoblinFactory();
        character = new Character("Player 2", raceFactory.create());
        character.talk();
    }
}