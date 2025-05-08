/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

import java.util.Date;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public Date getDateCreated() {
        return super.getDateCreated();
    }

    @Override
    public double getperimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String howToDraw() {
        return "Draw a circle by starting from the center and drawing a curve with radius " + radius;
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", area=" + getArea() + ", color=" + getColor()
                + ", date created=" + getDateCreated() + ", perimeter=" + getperimeter() + "]";
    }

}
