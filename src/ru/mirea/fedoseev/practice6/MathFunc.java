package ru.mirea.fedoseev.practice6;

public class MathFunc implements MathCalculable {

    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double complexModule(double real, double imaginary) {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double circleLength(double radius) {
        return 2 * PI * radius;
    }

    public double circleArea(double radius) {
        return PI * radius * radius;
    }
}
