package oop;
import java.util.Date;

public abstract class Shape implements Drawable {

    private String color;
    final private Date dateCreated = new Date();

    public Date getDateCreated() {
        return dateCreated;
    }

    public abstract double getArea();

    public abstract double getperimeter();

    @Override
    public abstract String howToDraw();

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
