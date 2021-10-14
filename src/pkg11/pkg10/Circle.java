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
public class Circle extends AbstractShape{
    
    protected int radius;
    protected Color color;
    
    public Circle(){
        super();
        radius = 1;
        color = Color.black;
    }
    
    public Circle(int xLoc, int yLoc, int r, Color c){
        super(xLoc, yLoc);
        radius = r;
        color = c;
    }
    
    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
    
    @Override
    public double perimeter(){
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        if (fill)
            g.fillOval(xPos - radius, yPos - radius, radius * 2, radius * 2);
        else
            g.drawOval(xPos - radius, yPos - radius, radius * 2, radius * 2);
    }
    
    @Override
    public boolean containsPoint (int x, int y) {
        if (Math.sqrt( Math.pow(xPos - x, 2) + Math.pow(yPos - y, 2) ) <= radius)
            return true;
        
        return false;
    }
    
    @Override
    public void stretchBy(double factor){
        radius *= factor;
    }
    
    @Override
    public String toString(){
        String str = "CIRCLE\n"
                   + "Radius: " + radius + "\n"
                   + super.toString();
        return str;
    }
}
