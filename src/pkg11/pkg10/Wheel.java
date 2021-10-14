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
public class Wheel extends Circle{
    
    private int spokes;
    
    public Wheel(){
        super();
        spokes = 0;
    }
    
    public Wheel(int xLoc, int yLoc, int r, int s, Color c){
        super(xLoc, yLoc, r, c);
        spokes = s;
    }
    
    @Override
    public void draw(Graphics g){
        super.draw(g);
        if (!fill)
            for (int i = 1; i <= spokes; i++)
                g.drawLine(xPos, yPos, xPos + (int) Math.cos(i * 360.0 / spokes), yPos + (int) Math.sin(i * 360.0 / spokes));
    }
    
    public void setSpokes(int s){
        spokes = s;
    }
    
    @Override
    public String toString(){
        String str = "WHEEL\n"
                   + "Radius: " + radius + "\n"
                   + "Spokes: " + spokes + "\n"
                   + "(X,Y) Position: (" + xPos + "," + yPos + ")\n"
                   + "Area " + area();
        return str;
    }
}
