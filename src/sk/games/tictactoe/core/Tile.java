package sk.games.tictactoe.core;

public abstract class Tile {

    public enum State {
        OPEN,
        CLOSED
    }

    private State state = State.OPEN;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "-";
    }
}
