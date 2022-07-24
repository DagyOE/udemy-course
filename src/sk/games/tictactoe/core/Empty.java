package sk.games.tictactoe.core;

public class Empty extends Tile{

    String symbol;

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        if (this.getState() == State.CLOSED) {
            return symbol;
        }
        return super.toString();
    }
}
