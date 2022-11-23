import entities.dndclasses.Paladin;
import entities.Character;
import entities.races.Goblin;
import entities.stats.Stats;
import visitor.ElementVisitor;


public class VisitorPatternDemo {
    public static void main(String[] args) {
        Character character = new Character("Player 1", new Paladin(), Stats.generate(), new Goblin());

        ElementVisitor saver = new ElementVisitor();

        character.accept(saver);
        System.out.println("\nRace Info:");
        character.getRace().accept(saver);
        System.out.println("\nClass Info:");
        character.getCharacterClass().accept(saver);
        System.out.println("\nStats Info:");
        character.getStats().accept(saver);
    }
}