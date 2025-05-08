/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

/**
 *
 * @author George
 */
public abstract class ThreeDShape extends Shape {
    
        public ThreeDShape(){}
    public ThreeDShape(String color) {
        super(color);
    }

    public abstract double getVolume();
    
}
