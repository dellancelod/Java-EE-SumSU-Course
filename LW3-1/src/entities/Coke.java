package entities;

import interfaces.Packing;

public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
