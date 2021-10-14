/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg10;
import java.awt.*;
/**
 *
 * @author tommu
 */
public interface Shape {
    public double area();
    public double perimeter();
    public void draw(Graphics g);
    public boolean containsPoint(int x, int y);
    public void setFilled(boolean b);
    public int getXPos();
    public int getYPos();
    public void move(int xLoc, int yLoc);
    public void stretchBy(double factor);
    public String toString();
}
