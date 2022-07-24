package sk.games.puzzle;

import java.io.*;
import java.util.*;

public class BestTimes implements Iterable<BestTimes.PlayerTime>, Serializable{

    private static final String BESTTIME_DB = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "best_time_db.db";

    private List<PlayerTime> playerTimes = new ArrayList<>();

    public Iterator<PlayerTime> iterator() {
        return playerTimes.iterator();
    }

    public void addTime(String name, int time){
        playerTimes.add(new PlayerTime(name, time));
        Collections.sort(playerTimes);
        this.save();
    }

    public void load() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(BESTTIME_DB);
        } catch (FileNotFoundException e) {
            System.err.println("Fail db neexistuje");
        } finally {
            if (fis != null) {
                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(fis);
                    if (ois != null) {
                        try {
                            playerTimes = (ArrayList<PlayerTime>) ois.readObject();
                        } catch (ClassNotFoundException e) {
                            System.err.println("Fail nebola najdena trieda");
                        }
                    } else {
                    }
                    assert ois != null;
                    ois.close();
                    } catch (IOException e) {
                    System.err.println("Fail nepodarilo sa otvoril db");
                }
            }
        }
    }

    public void save() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(BESTTIME_DB);
        } catch (FileNotFoundException e) {
            System.err.println("Fail db neexistuje");
        } finally {
            if (fos != null) {
                ObjectOutputStream oos = null;
                try{
                    oos = new ObjectOutputStream(fos);
                    if (oos != null) {
                        oos.writeObject(playerTimes);
                    }
                    assert oos != null;
                    oos.close();
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

    public static class PlayerTime implements Comparable<PlayerTime> {

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
