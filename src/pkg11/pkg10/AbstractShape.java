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
abstract public class AbstractShape implements Shape{
    
    protected int xPos;
    protected int yPos;
    protected boolean fill;
    
    public AbstractShape(int xLoc, int yLoc){
        xPos = xLoc;
        yPos = yLoc;
    }
    
    public AbstractShape(){
        this(0, 0);
    }
    
    @Override
    public final void setFilled (boolean b) {
        fill = b;
    }
    
    @Override
    public int getXPos(){
        return xPos;
    }
    
    @Override
    public int getYPos(){
        return yPos;
    }
    
    @Override
    public void move(int xLoc, int yLoc){
        xPos = xLoc;
        yPos = yLoc;
    }
    
    @Override
    public String toString(){
        String str = "(X,Y) Position: (" + xPos + "," + yPos + ")\n"
                   + "Area: " + area();
        return str;
    }
}
