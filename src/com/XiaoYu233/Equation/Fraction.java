package com.XiaoYu233.Equation;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Fraction {
    double up, down;

    public Fraction(double up, double down) {
        if (down == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.up = up;
        this.down = down;
    }

    public static Fraction fromInt(int value) {
        return new Fraction(value, 1);
    }

    public static Fraction fromDouble(double value) {
        int i = 0;
        while (value > (double) ((int) value)) {
            value *= 10;
            i++;
        }
        return new Fraction(value, i * 10);
    }
    public static Fraction fromString(String value){
        int splitterIndex = value.indexOf("/");
        return new Fraction(Double.parseDouble(value.substring(0,splitterIndex)),Double.parseDouble(value.substring(splitterIndex+1)));
    }

    public boolean isFakeFraction() {
        return Math.abs(up) > Math.abs(down);
    }

    public boolean isMinus() {
        return up * down < 0;
    }

    public double value() {
        return this.up / this.down;
    }

    public void plus(Fraction other) {
        this.up *= other.down;
        this.up += other.up * this.down;
        this.down *= other.down;
    }

    public void subtract(Fraction other) {
        other.toMinus();
        this.plus(other);
        other.toMinus();
    }

    public void multiply(Fraction other) {
        this.up *= other.up;
        this.down *= other.down;
    }

    public void divide(Fraction other) {
        this.up *= other.down;
        this.down *= other.up;
    }

    public void toMinus() {
        this.up = -this.up;
    }

    @Override
    public String toString() {
        return this.up % this.down == 0 ? String.valueOf((int)( this.up / this.down)) : this.up + "/" + this.down;
    }
}
