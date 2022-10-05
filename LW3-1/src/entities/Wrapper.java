package entities;

import interfaces.Packing;

public class Wrapper implements Packing {
    @Override
    public String packingName() {
        return "Wrapper";
    }
}
