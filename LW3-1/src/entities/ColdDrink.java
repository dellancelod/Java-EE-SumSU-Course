package entities;

import interfaces.Item;
import interfaces.Packing;

public class ColdDrink implements Item {
    
    @Override
    public String name() {
        return null;
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 0;
    }
}
