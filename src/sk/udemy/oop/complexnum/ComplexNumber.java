package sk.udemy.oop.complexnum;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(double r, double i) {
        this.real += r;
        this.imaginary += i;
    }

    public void substract(ComplexNumber num) {
        this.real -= num.getReal();
        this.imaginary -= num.getImaginary();
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
}
