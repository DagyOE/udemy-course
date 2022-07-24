package sk.games.puzzle;

import java.io.*;
import java.util.*;

public class BestTimes implements Iterable<BestTimes.PlayerTime>{

    private static final String BESTTIME_DB = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "best.time";

    private List<PlayerTime> playerTimes = new ArrayList<>();

    public Iterator<PlayerTime> iterator() {
        return playerTimes.iterator();
    }

    public void addTime(String name, int time){
        playerTimes.add(new PlayerTime(name, time));
        Collections.sort(playerTimes);
    }

    public void load(){
        ObjectInputStream load = null;
        try {
            load = new ObjectInputStream(new FileInputStream(BESTTIME_DB));
            playerTimes = (ArrayList<PlayerTime>) load.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("fail nebola najdena db");
        } catch (IOException e) {
            System.err.println("fail nebola otvorena db");
        } catch (ClassNotFoundException e) {
            System.err.println("fail nebol najdeny zaznam");
        } finally {
            if (load != null) {
                try {
                    load.close();
                } catch (IOException e) {
                    //empty
                }
            }
        }
    }

    public void save() {
        ObjectOutputStream save = null;
        try {
            save = new ObjectOutputStream(new FileOutputStream(BESTTIME_DB));
            save.writeObject(playerTimes);
        } catch (FileNotFoundException e) {
            System.err.println("fail db neexistuje");
        } catch (IOException e) {
            System.err.println("fail nepodarilo sa otvorit db");
        } finally {
            if (save != null) {
                try {
                    save.close();
                } catch (IOException e) {
                    //empty
                }
            }
        }
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        for (int i = 0; i < playerTimes.size(); i++) {
            PlayerTime pt = playerTimes.get(i);
            f.format("%02d. %s - %ds.\n", i, pt.getName(), pt.getTime());
        }
        return f.toString();
    }

    public static class PlayerTime implements Comparable<PlayerTime>, Serializable {

        private final String name;
        private final int time;

        public PlayerTime(String name, int time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(PlayerTime o){
            return Integer.compare(this.time, o.getTime());
        }
    }
}
