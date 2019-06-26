package com.seo;

public class Block {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private TYPE type;
    private COLOR color;

    public Block(int x1, int y1, int x2, int y2, TYPE type, COLOR color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.type = type;
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public Dimension getUpperLeft() {
        return new Dimension(getX1(), getY1());
    }

    public Dimension getUpperRight() {
        return new Dimension(getX2(), getY1());
    }

    public Dimension getLowerLeft() {
        return new Dimension(getX1(), getY2());
    }

    public Dimension getLowerRight() {
        return new Dimension(getX2(), getY2());
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}

enum TYPE {
    ROOK, BISHOP, QUEEN, KNIGHT, KING, PAWN, NONE;
}

enum COLOR {
    BLACK, WHITE;
}

class Dimension {
    int x;
    int y;

    public Dimension(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
