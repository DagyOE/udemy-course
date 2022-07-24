package sk.games.puzzle.core;

public class Clue extends Tile{

    private final char value;

    public Clue(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        if (this.getState() == State.OPEN) {
            return String.valueOf(this.value);
        }
        return super.toString();
    }
}
