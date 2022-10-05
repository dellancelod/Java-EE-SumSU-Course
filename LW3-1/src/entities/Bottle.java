package entities;

import interfaces.Packing;

public class Bottle implements Packing {
    @Override
    public String packingName() {
        return "Bottle";
    }
}
