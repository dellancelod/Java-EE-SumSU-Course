package entities;

import interfaces.Item;
import interfaces.Packing;

public class Burger implements Item {

    @Override
    public String name() {
        return null;
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 0;
    }
}
