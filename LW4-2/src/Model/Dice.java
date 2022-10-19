package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Dice {
    private static Random diceRoller = new Random();

    private static int rollD6(){
        return diceRoller.nextInt(6);
    }

    public static int rollStat(){
        ArrayList<Integer> stats = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            stats.add(rollD6());
        }
        Integer max = Collections.max(stats);

        int calculatedStat = 0;

        for (Integer stat : stats) {
            if (stat.equals(max)) {
                calculatedStat += stat;
            }
        }
        return calculatedStat;
    }
}
