package entities.factories;

import entities.races.CharacterRace;
import entities.races.Goblin;

public class GoblinFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new Goblin();
    }
}
