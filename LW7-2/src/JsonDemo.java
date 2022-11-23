import entities.dndclasses.Paladin;
import entities.Character;
import entities.races.Goblin;
import entities.stats.Stats;
import json.JsonSerialization;
import visitor.ElementVisitor;

import java.util.TreeMap;


public class JsonDemo {
    public static void main(String[] args) {
        Character character = new Character("Player 1", new Paladin(), Stats.generate(), new Goblin());

        ElementVisitor saver = new ElementVisitor();

        character.accept(saver);
        character.getRace().accept(saver);
        character.getCharacterClass().accept(saver);
        character.getStats().accept(saver);

        TreeMap<String, String> treeMap = saver.getTreeMap();

        JsonSerialization jsonSerialization = new JsonSerialization();
        jsonSerialization.write("LW7-2/resources/characters.json", treeMap);
    }
}