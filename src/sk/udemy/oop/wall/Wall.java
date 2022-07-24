package sk.udemy.oop.wall;

public class Wall {

    private double width;
    private double height;

    public Wall(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0.0){
            this.width = width;
        } else {
            this.width = 0;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0.0) {
            this.height = height;
        } else {
            this.height = 0;
        }
    }
}