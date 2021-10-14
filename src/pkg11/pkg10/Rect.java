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
public class Rect extends AbstractShape{
    
    private int height, width;
    private Color color;
    
    public Rect(){
        super();
        height = 1;
        width = 1;
        color = Color.black;
    }
    
    public Rect(int xLoc, int yLoc, int w, int h, Color c){
        super(xLoc, yLoc);
        
        if (w < 0) {
            xPos += w;
            width = Math.abs(w);
        } else
            width = w;
        
        if (w < 0) {
            yPos += h;
            height = Math.abs(h);
        } else
            height = h;
        
        color = c;
    }
    
    @Override
    public double area(){
        return height * width;
    }
    
    @Override
    public double perimeter(){
        return 2 * height + 2 * width;
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        if (fill)
            g.fillRect(xPos, yPos, width, height);
        else
            g.drawRect(xPos, yPos, width, height);
    }
    
    @Override
    public boolean containsPoint (int x, int y) {
        if ((xPos < x && x < xPos + width) && (yPos < y && y < yPos + height))
            return true;
        
        return false;
    }
    
    @Override
    public void stretchBy(double factor){
        height *= factor;
        width *= factor;
    }
    
    @Override
    public void move (int xLoc, int yLoc) {
        xPos = xLoc - width / 2;
        yPos = yLoc - height / 2;
    }
    
    @Override
    public String toString(){
        String str = "Circle\n"
                   + "Width & Height: " + width + " & " + height + "\n"
                   + super.toString();
        return str;
    }
}
