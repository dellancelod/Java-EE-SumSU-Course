package controller.serializing.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList;

    public CareTaker(){
        mementoList = new ArrayList<>();
    }

    public void add(Memento memento){
        mementoList.add(memento);
        System.out.println("Saving done!");
    }

    public void printMementoList(){
        int index = 0;
        for (Memento memento : mementoList){
            System.out.println(index + " " + memento.getState());
            index++;
        }
    }

    public Memento get(int i){
        return mementoList.get(i);
    }

    public Memento get(){
        if (mementoList.size() == 0) {
            return null;
        }
        System.out.println("Loading...");
        return mementoList.get(mementoList.size() - 1);
    }
    public List<Memento> getSaves() {
        return mementoList;
    }
}
