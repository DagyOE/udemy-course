package sk.games.puzzle.ui;

import sk.games.puzzle.Puzzle;
import sk.games.puzzle.UserInterface;
import sk.games.puzzle.core.Field;
import sk.games.puzzle.core.GameStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WrongFormatException extends Exception {
    public WrongFormatException(String message) {
        super(message);
    }
}

public class ConsoleUI implements UserInterface {

    private Field field;
    private String player;

    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void newGameStarted(Field field) {
        this.field = field;
        System.out.print("Set player name: ");
        this.player = readLine();
        do {
            for (int i = 1; i <= 2; i++) {
                update();
                input(i);
            }
        } while (true);
    }

    public void update() {
        System.out.print("   ");
        for (int i = 0; i < this.field.getRowCount(); i++) {
            System.out.printf("%3s", i);
        }
        System.out.print("\n");
        for (int i = 0; i < field.getRowCount(); i++) {
            if (i <= 25) {
                System.out.printf("%3c", 65 + i);
            } else {
                System.out.printf("%3c", 71 + i);
            }
            for (int col = 0; col < this.field.getColumnCount(); col++) {
                System.out.printf("%3s", field.getTile(i, col));
            }
            System.out.print("\n");
        }
    }

    private Matcher pattern(String input, String regexLine) {
        Pattern pattern = Pattern.compile(regexLine);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

    private void formattedInput(String line) throws WrongFormatException {
        Matcher matcher = pattern(line, "(O)([A-Z])(\\d)");
        if (input.equals("X") || input.equals("x")){
            System.exit(0);
        }
        if (matcher.matches()){
            int x = matcher.group(2).charAt(0) - 65;
            int y = Integer.parseInt(matcher.group(3));
            field.openTile(x, y);
            if (this.field.getState() == GameStatus.SOLVED) {
                int time = Puzzle.getInstance().getPlayTime();
                update();
                System.out.println("Nice, " + player + " are winner. Your game time is: " + time + "s.");
                System.out.println("Best times rank:");
                Puzzle.getInstance().getBestTimes().addTime(player, time);
                System.out.println(Puzzle.getInstance().getBestTimes().toString());
                Puzzle.getInstance().getBestTimes().save();
                System.exit(0);
            }
        } else {
            throw new WrongFormatException("\nWrong input format, round failed");
        }
    }

    private void input(int i) {
        System.out.print("Please enter your " + i + " selection [Open -> [OA1], Exit -> [X]]: ");
        String line = readLine();
        try {
            formattedInput(line);
        } catch (WrongFormatException e) {
            System.err.println(e.getMessage());
            input(i);
        }
    }
}
