/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;


import java.util.Date;

public class Cube extends ThreeDShape {

    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public Cube(double side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getArea() {
        return side * side * 6;
    }

    @Override
    public Date getDateCreated() {
        return super.getDateCreated();
    }

    @Override
    public double getperimeter() {
        return side * 4 * 6;
    }

    @Override
    public String howToDraw() {
        return "Draw a cube with side " + side;
    }


    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String toString() {
        return "Cube [side=" + side + ", volume=" + getVolume() + ", area=" + getArea()
                + ", date created=" + getDateCreated() + ", perimeter=" + getperimeter() + ", color="
                + getColor() + "]";
    }

}

