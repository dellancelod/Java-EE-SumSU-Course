package entities.factories;

import entities.races.CharacterRace;
import entities.races.LightfootHalfling;

public class LightfootHalflingFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new LightfootHalfling();
    }
}
