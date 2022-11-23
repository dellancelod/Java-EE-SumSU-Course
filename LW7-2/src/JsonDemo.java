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

        ElementVisitor saver = new ElementVisitor();

        character1.accept(saver);
        character1.getRace().accept(saver);
        character1.getCharacterClass().accept(saver);
        character1.getStats().accept(saver);

        TreeMap<String, String> treeMapCharacter1 = saver.getTreeMap();

        Character character2 = new Character("Player 2", new Rogue(), Stats.generate(), new LightfootHalfling());

        character2.accept(saver);
        character2.getRace().accept(saver);
        character2.getCharacterClass().accept(saver);
        character2.getStats().accept(saver);

        TreeMap<String, String> treeMapCharacter2 = saver.getTreeMap();

        JsonSerialization jsonSerialization = new JsonSerialization();
        jsonSerialization.write("LW7-2/resources/characters.json", treeMapCharacter1, treeMapCharacter2);

    }
}