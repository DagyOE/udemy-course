package sk.games.puzzle.core;

public class Tile {

    public enum State {
        OPEN,
        CLOSED,
        SOLVED
    }

    private State state = State.CLOSED;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if (this.getState() == State.SOLVED){
            return "*";
        }
        return "-";
    }
}
