package com.robot.model;

public class Transmitter {
    private int x;
    private int y;
    private int A;
    private int n;

    public Transmitter(int x, int y, int A, int n) {
        this.x = x;
        this.y = y;
        this.A = A;
        this.n = n;
    }

    public double getSignal(int x, int y) {
        double distance = Math.sqrt((this.x - x)*(this.x - x) + (this.y - y)*(this.y - y));

        return A - 10 * n * Math.log(distance);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Transmitter {x=" + x + "; y=" + y + "}";
    }
}
