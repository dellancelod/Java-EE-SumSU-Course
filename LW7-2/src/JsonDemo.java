import entities.dndclasses.Paladin;
import entities.Character;
import entities.dndclasses.Rogue;
import entities.races.Goblin;
import entities.races.LightfootHalfling;
import entities.stats.Stats;
import json.JsonSerialization;
import visitor.ElementVisitor;

import java.util.TreeMap;


public class JsonDemo {
    public static void main(String[] args) {
        Character character1 = new Character("Player 1", new Paladin(), Stats.generate(), new Goblin());

        ElementVisitor saver1 = new ElementVisitor();

        character1.accept(saver1);
        character1.getRace().accept(saver1);
        character1.getCharacterClass().accept(saver1);
        character1.getStats().accept(saver1);

        TreeMap<String, String> treeMapCharacter1 = saver1.getTreeMap();

        ElementVisitor saver2 = new ElementVisitor();

        Character character2 = new Character("Player 2", new Rogue(), Stats.generate(), new LightfootHalfling());

        character2.accept(saver2);
        character2.getRace().accept(saver2);
        character2.getCharacterClass().accept(saver2);
        character2.getStats().accept(saver2);

        TreeMap<String, String> treeMapCharacter2 = saver2.getTreeMap();

        JsonSerialization jsonSerialization = new JsonSerialization();
        jsonSerialization.write("LW7-2/resources/characters.json", treeMapCharacter1, treeMapCharacter2);

    }
}