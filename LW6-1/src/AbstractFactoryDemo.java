import entities.Character;

public class AbstractFactoryDemo {
    public static ClassAbstractFactory factory;
    public static void main(String[] args) {
        Character character = new Character("Player 1", factory.getClass("Paladin"));
        character.talk();

        System.out.println("\n" + character.getName() + " activated his bonus\n");

        character.addBonuses();
        character.talk();

        character = new Character("Player 2", ClassAbstractFactory.getClass("Rogue"));
        character.talk();

        System.out.println("\n" + character.getName() + " activated his bonus\n");

        character.addBonuses();
        character.talk();
    }
}