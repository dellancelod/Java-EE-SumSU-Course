package visitor;

import entities.Character;
import entities.dndclasses.CharacterClass;
import entities.races.CharacterRace;
import entities.stats.Stats;

public class ElementVisitor implements DataElementVisitor{
    @Override
    public void visit(Character character) {
        System.out.println("NameCharacter: " + character.getName());
    }

    @Override
    public void visit(Stats stats) {
        stats.getStats().forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }

    @Override
    public void visit(CharacterRace race) {
        System.out.println("CharacterRace: " + race.getName());
        race.getBonuses().getStats().forEach((key, value) -> System.out.printf("bonus %s: %d\n", key, value));
    }

    @Override
    public void visit(CharacterClass characterClass) {
        System.out.println("CharacterClass: " + characterClass.getName());
        System.out.println("HP: " + characterClass.getHp());
    }
}
