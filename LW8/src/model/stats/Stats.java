package model.stats;


import controller.serializing.memento.Memento;

import java.util.HashMap;

public class Stats  {
    private HashMap<String, Integer> stats;

    private Stats() {
        stats = new HashMap<>();
    }

    public Stats(int strength,
                 int dexterity,
                 int constitution,
                 int intelligence,
                 int wisdom,
                 int charisma) {
        stats = new HashMap<>();

        stats.put("strength", strength);
        stats.put("dexterity", dexterity);
        stats.put("constitution", constitution);
        stats.put("intelligence", intelligence);
        stats.put("wisdom", wisdom);
        stats.put("charisma", charisma);
    }

    public static Stats generate() {
        Stats stats = new Stats();

        stats.stats.put("strength", roll());
        stats.stats.put("dexterity", roll());
        stats.stats.put("constitution", roll());
        stats.stats.put("intelligence", roll());
        stats.stats.put("wisdom", roll());
        stats.stats.put("charisma", roll());

        return stats;
    }

    private static int roll(){
        double f = Math.random() / Math.nextDown(1.0);
        return (int)((1.0 - f) + (6D + 1) * f);
    }

    public HashMap<String, Integer> getStats(){
        return stats;
    }

    public Memento save() {
        return new Memento(this);
    }


}
