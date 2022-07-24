package sk.udemy.oop.carpet;

public class Floor {

    private double width;
    private double lenght;

    public Floor(double width, double lenght) {
        setWidth(width);
        setLenght(lenght);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width >= 0 ) {
            this.width = width;
        }
        else {
            this.width = 0;
        }
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        if (width >= 0 ) {
            this.lenght = lenght;
        }
        else {
            this.lenght = 0;
        }
    }
}
