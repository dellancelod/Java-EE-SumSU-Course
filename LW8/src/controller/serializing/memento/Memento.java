package controller.serializing.memento;

import model.stats.Stats;


public class Memento {
    private String state;
    private Stats mementoStats;

    public Memento(Stats stats){
        mementoStats = stats;
        state = String.valueOf(java.time.LocalDateTime.now());
    }

    public String getState(){
        return state;
    }

    public Stats getStats(){
        return mementoStats;
    }
}
