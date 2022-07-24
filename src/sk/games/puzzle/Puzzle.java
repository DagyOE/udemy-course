package sk.games.puzzle;

import sk.games.puzzle.core.Field;
import sk.games.puzzle.ui.ConsoleUI;

public class Puzzle {

    private UserInterface userInterface;
    private static Puzzle instance;
    private long startTime;
    private BestTimes bestTimes = new BestTimes();

    public static Puzzle getInstance() {
        if (instance == null) {
            new Puzzle();
        }
        return instance;
    }

    private Puzzle() {
        instance = this;
        bestTimes.load();

        System.out.println("Welcome in Puzzle Game");

        Field field = new Field(2, 2);
        userInterface = new ConsoleUI();
        this.startTime = System.currentTimeMillis();
        userInterface.newGameStarted(field);
    }

    public BestTimes getBestTimes() {
        return bestTimes;
    }

    public int getPlayTime() {
        return (int) (System.currentTimeMillis() - startTime) / 1000;
    }



    public static void main(String[] args) {
        Puzzle.getInstance();
    }
}
