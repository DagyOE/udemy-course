package sk.games.tictactoe;

import sk.games.tictactoe.core.Field;
import sk.games.tictactoe.ui.ConsoleUI;

public class TicTacToe {

    private UserInterface userInterface;
    private static TicTacToe instance;

    public static TicTacToe getInstance() {
        if (instance == null) {
            new TicTacToe();
        }
        return instance;
    }

    private TicTacToe() {
        instance = this;
        System.out.println("Welcome in TicTacToe game.");
        Field field = new Field();
        userInterface = new ConsoleUI();
        userInterface.newGameStarted(field);
    }

    public static void main(String[] args) {
        TicTacToe.getInstance();
    }
}
