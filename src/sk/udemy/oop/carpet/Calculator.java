package sk.udemy.oop.carpet;

import sk.udemy.oop.carpet.Carpet;
import sk.udemy.oop.carpet.Floor;

public class Calculator {

    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        return floor.getWidth() * floor.getLenght() * carpet.getCost();
    }
}
