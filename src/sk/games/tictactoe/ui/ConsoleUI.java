package sk.games.tictactoe.ui;

import sk.games.tictactoe.UserInterface;
import sk.games.tictactoe.core.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleUI implements UserInterface {

    private Field field;
    private String player1;
    private String player2;

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
        System.out.print("Set player [O] name: ");
        this.player1 = readLine();
        System.out.print("Set player [X] name: ");
        this.player2 = readLine();
        do {
            update();
            processInput();
        } while (true);
    }

    private void update() {
        System.out.print("   ");
        for (int c = 0; c < field.getX(); c++) {
            System.out.printf("%3s", c);
        }
        System.out.print("\n");
        for (int x = 0; x < field.getX(); x++) {
            System.out.printf("%3s", x);
            for (int y = 0; y < field.getY(); y++) {
                System.out.printf("%3s", field.getTile(x, y));
            }
            System.out.printf("\n");
        }
    }

    private Matcher pattern(String input) {
        Pattern pattern = Pattern.compile("(O)([A-C])(\\d)");
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }


    private void input(String input, int player) {
        Matcher matcher = pattern(input);
        if (input.equals("X") || input.equals("x")){
            System.exit(0);
        }
        if (matcher.matches()){
            int x = matcher.group(2).charAt(0) - 65;
            int y = Integer.parseInt(matcher.group(3));
            System.out.println(x + " - " + y + " -> " + player);
            field.openTile(x, y, player);
        }
    }

    private void processInput() {
        System.out.print("Player [0] select tile [OA1]: ");
        String p1 = readLine();
        input(p1, 1);
        System.out.print("Player [X] select tile [OC2]: ");
        String p2 = readLine();
        input(p2, 2);
    }
}
