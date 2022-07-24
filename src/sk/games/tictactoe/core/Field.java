package sk.games.tictactoe.core;

import static sk.games.tictactoe.core.Tile.State.CLOSED;
import static sk.games.tictactoe.core.Tile.State.OPEN;

public class Field {

    private GameStatus status = GameStatus.PLAYING;

    private final Tile[][] tiles;

    private int x = 3;
    private int y = 3;

    public Field() {
        tiles = new Tile[x][y];
        generate();
    }

    public void openTile(int x, int y, int player) {
        System.out.println(tiles[x][y].getState());
        System.out.println(tiles[x][y]);
        if (tiles[x][y].getState() == OPEN) {
            if (player == 1 && tiles[x][y] instanceof Empty) {
                ((Empty) tiles[x][y]).setSymbol("O");
                System.out.println(tiles[x][y].getState());
                System.out.println(tiles[x][y]);
            } else {
                tiles[x][y] = new X();
            }
        }
    }

    private void generate() {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                if (tiles[x][y] == null){
                    tiles[x][y] = new Empty();
                    tiles[x][y].setState(OPEN);
                }
            }
        }
    }

    public Tile getTile(int x, int y) {
        return this.tiles[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
