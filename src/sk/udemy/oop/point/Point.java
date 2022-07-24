package sk.udemy.oop.point;

public class Point {

    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(){
        int xB = 0;
        int yB = 0;
        return Math.sqrt(((xB-x)*(xB-x)+(yB-y)*(yB-y)));
    }

    public double distance(int xB, int yB){
        return Math.sqrt(((xB-x)*(xB-x)+(yB-y)*(yB-y)));
    }

    public double distance(Point b){
        return Math.sqrt(((b.getX()-x)*(b.getX()-x)+(b.getY()-y)*(b.getY()-y)));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
