package entities;

import interfaces.Packing;

public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Vegetarian Burger";
    }

    @Override
    public float price() {
        return 40.0f;
    }
}
