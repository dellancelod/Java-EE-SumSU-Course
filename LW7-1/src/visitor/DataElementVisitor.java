package visitor;

import entities.dndclasses.CharacterClass;
import entities.races.CharacterRace;
import entities.stats.Stats;
import entities.Character;

public interface DataElementVisitor {

    void visit(Character character);

    void visit(Stats stats);

    void visit(CharacterRace race);

    void visit(CharacterClass race);

}