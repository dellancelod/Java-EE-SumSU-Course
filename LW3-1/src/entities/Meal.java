package entities;

import interfaces.Item;
import java.util.ArrayList;

public class Meal {
    private ArrayList<Item> items = new ArrayList<Item>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }
    public void showItems(){
        System.out.println("Items in meal:");
        for (Item item : items) {
            System.out.println(item.name() + "\n" +
                    "\tPrice: " + item.price() + "\n" +
                    "\tPacking: " + item.packing().packingName() + " UAH");
        }
    }
}
