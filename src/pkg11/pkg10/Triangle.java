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
public class Triangle extends AbstractShape{
    
    private int xPos2, yPos2, xPos3, yPos3;
    private Color color;
    
    public Triangle(int xLoc1, int yLoc1, int xLoc2, int yLoc2, int xLoc3, int yLoc3, Color c){
        super(xLoc1, yLoc1);
        xPos2 = xLoc2;
        yPos2 = yLoc2;
        xPos3 = xLoc3;
        yPos3 = yLoc3;
        color = c;
    }
    
    public Triangle(){
        this(0, 0, 2, 0, 2, 2, Color.black);
    }
    
    @Override
    public double area(){
        return 0.5 * Math.abs(xPos * yPos2
                            - xPos2 * yPos 
                            + xPos2 * yPos3
                            - xPos3 * yPos2
                            + xPos3 * yPos
                            - xPos * yPos3);
    }
    
    @Override
    public double perimeter(){
        return Math.sqrt( Math.pow(yPos - xPos2, 2)
                        + Math.pow(yPos - yPos2, 2) )
             + Math.sqrt( Math.pow(xPos2 - xPos3, 2)
                        + Math.pow(yPos2 - yPos3, 2) )
             + Math.sqrt( Math.pow(xPos3 - xPos, 2)
                        + Math.pow(yPos3 - yPos, 2) );
    }
    
    @Override
    public void draw(Graphics g){
        int[] xPoints = new int[]{xPos, xPos2, xPos3};
        int[] yPoints = new int[]{yPos, yPos2, yPos3};
        g.setColor(color);
        
        if (fill)
            g.fillPolygon(xPoints, yPoints, 3);
        else
            g.drawPolygon(xPoints, yPoints, 3);
    }
    
    @Override
    public boolean containsPoint (int x, int y) {
        double area1 = new Triangle(x, y, xPos2, yPos2, xPos3, yPos3, Color.black).area();
        double area2 = new Triangle(x, y, xPos, yPos, xPos2, yPos2, Color.black).area();
        double area3 = new Triangle(x, y, xPos, yPos, xPos3, yPos3, Color.black).area();
        
        if (area1 + area2 + area3 == area()) {
            return true;
        }
        
        return false;
    } 
    
    @Override
    public void move(int xLoc, int yLoc){
        int xCenter = (xPos + xPos2 + xPos3) / 3;
        int yCenter = (yPos + yPos2 + yPos3) / 3;
        
        int xCenterDistance = xCenter - xPos;
        int yCenterDistance = yCenter - yPos;
        
        int xDistance = xLoc - xPos;
        int yDistance = yLoc - yPos;
        
        super.move(xLoc - xCenterDistance, yLoc - yCenterDistance);
        
        xPos2 += xDistance - xCenterDistance;
        yPos2 += yDistance - yCenterDistance;
        
        xPos3 += xDistance - xCenterDistance;
        yPos3 += yDistance - yCenterDistance;
    }
    
    @Override
    public void stretchBy(double factor){
        xPos2 = xPos + (xPos2 - xPos) * (int) factor;
        yPos2 = yPos + (yPos2 - yPos) * (int) factor;
        
        xPos3 = xPos + (xPos3 - xPos) * (int) factor;
        yPos3 = yPos + (yPos3 - yPos) * (int) factor;
    }
}
