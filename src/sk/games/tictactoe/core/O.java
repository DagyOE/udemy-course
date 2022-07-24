package sk.games.tictactoe.core;

public class O extends Tile{

    @Override
    public String toString() {
        if (this.getState() == State.CLOSED) {
            return "O";
        }
        return super.toString();
    }
}
