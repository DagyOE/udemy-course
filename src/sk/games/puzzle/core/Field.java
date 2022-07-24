package sk.games.puzzle.core;
import java.util.Random;

public class Field {

    private final Tile[][] tiles;
    private final int rowCount;
    private final int columnCount;

    private GameStatus state = GameStatus.PLAYING;

    public Field(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.tiles = new Tile[rowCount][columnCount];
        generate();
    }

    public void openTile(int row, int col) {
        Tile tile = tiles[row][col];
        if (tile.getState() == Tile.State.CLOSED) {
            tile.setState(Tile.State.OPEN);
        }

        if ((openedTiles() % 2) == 0) {
            checkPair();
        }

        if (isSolved()){
            state = GameStatus.SOLVED;
        }
    }

    private void generate() {
        Random r = new Random();
        int pair = 2;
        char input = 'A';
        while (true) {
            int x = r.nextInt(this.rowCount);
            int y = r.nextInt(this.columnCount);
            if (nullTiles() > 0) {
                if (tiles[x][y] == null) {
                    if (pair > 0) {
                        tiles[x][y] = new Clue(input);
                        pair--;
                    } else {
                        pair = 2;
                        input++;
                    }
                }
            } else {
                break;
            }
        }
    }

    private int nullTiles() {
        int nullTiles = 0;
        for (int x = 0; x < this.tiles.length; x++) {
            for (int y = 0; y < this.tiles[0].length; y++) {
                if (this.tiles[x][y] == null) {
                    nullTiles++;
                }
            }
        }
        return nullTiles;
    }

    private int openedTiles() {
        int openedTiles = 0;
        for (int x = 0; x < this.tiles.length; x++) {
            for (int y = 0; y < this.tiles[0].length; y++) {
                if (this.tiles[x][y].getState() == Tile.State.OPEN) {
                    openedTiles++;
                }
            }
        }
        return openedTiles;
    }

    private void checkPair() {
        String[] pair = new String[2];
        int num = 0;
        for (int x = 0; x < this.tiles.length; x++) {
            for (int y = 0; y < this.tiles[0].length; y++) {
                if (this.tiles[x][y].getState() == Tile.State.OPEN) {
                    pair[num] = String.valueOf(this.tiles[x][y]);
                    num++;
                }
            }
        }
        if (pair[0].equals(pair[1])) {
            for (int x = 0; x < this.tiles.length; x++) {
                for (int y = 0; y < this.tiles[0].length; y++) {
                    if (this.tiles[x][y].getState() == Tile.State.OPEN) {
                        this.tiles[x][y].setState(Tile.State.SOLVED);
                    }
                }
            }
        } else {
            for (int x = 0; x < this.tiles.length; x++) {
                for (int y = 0; y < this.tiles[0].length; y++) {
                    if (this.tiles[x][y].getState() == Tile.State.OPEN) {
                        this.tiles[x][y].setState(Tile.State.CLOSED);
                    }
                }
            }
        }
    }

    public boolean isSolved() {
        int count = 0;
        for (int x = 0; x < this.tiles.length; x++) {
            for (int y = 0; y < this.tiles[0].length; y++) {
                if (this.tiles[x][y].getState() == Tile.State.SOLVED) {
                    count++;
                }
            }
        }
        if (count == (this.tiles.length*this.tiles[0].length)) {
            return true;
        }
        return false;
    }

    public Tile getTile(int row, int col) {
        return this.tiles[row][col];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public GameStatus getState() {
        return state;
    }
}
