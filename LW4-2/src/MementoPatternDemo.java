import Model.Character;
import Model.MementoPattern.CareTaker;
import Model.MementoPattern.Memento;

public class MementoPatternDemo {
    public static void main(String[] args) {
        Character character = new Character("William", "Warrior");
        CareTaker ct = new CareTaker();

        System.out.println();
        character.printSheet();
        Memento save = character.getAttributes().save();
        ct.add(save);

        character.generateNewStats();
        System.out.println();
        character.printSheet();
        save = character.getAttributes().save();
        ct.add(save);

        System.out.println("\n\nLoading the first save...");
        System.out.println();
        character.loadAttributes(ct.get(0));
        character.printSheet();

        System.out.println("\nChanges log: ");
        ct.printMementoList();

    }
}