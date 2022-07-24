package sk.games.tictactoe.core;

public class X extends Tile{

    @Override
    public String toString() {
        if (this.getState() == State.CLOSED) {
            return "X";
        }
        return super.toString();
    }
}
