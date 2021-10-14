/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author tommu
 */
public class ColorPanel extends JPanel {
    
    private ShapeModel database;
    private Shape selectedShape;
    private int x, y;
    private String manipType;
    private String shapeType;
    private Color color;
    private boolean fill;
    
    public ColorPanel (Color backColor) {
        setBackground(backColor);
        database = new ShapeModel();
        selectedShape = null;
        manipType = "Create";
        shapeType = "Circle";
        color = Color.black;
        fill = true;
        addMouseListener( new PanelListener() );
        addMouseMotionListener( new PanelMotionListener() );
    }
    
    public void setManipType (String type) {
        manipType = type;
    }
    
    public void setShapeType (String type) {
        shapeType = type;
    }
    
    public void setColor (Color c) {
        color = c;
    }
    
    public void setFilled (boolean b) {
        fill = b;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        database.draw(g);
    }
    
    private class PanelListener extends MouseAdapter {
        public void mousePressed (MouseEvent e) {
            x = e.getX();
            y = e.getY();
            
            if (manipType.equals("Create")) return;
            
            selectedShape = database.containsPoint(x, y);
            if(manipType.equals("Delete") && selectedShape != null) {
                database.remove(selectedShape);
                selectedShape = null;
                repaint();
                return;
            }
        }
    
        public void mouseReleased (MouseEvent e) {
            int newX = e.getX();
            int newY = e.getY();
            
            int dx = newX - x;
            int dy = newY - y;

            if (manipType.equals("Create")) {

                Shape s;
                if (shapeType.equals("Circle")) {
                    if (dx < 0) {
                        dx = Math.abs(dx);
                    }
                        
                    s = new Circle(newX, newY, dx, color);
                } else if (shapeType.equals("Rectangle"))
                   s = new Rect(x, y, dx, dy, color);
                else {
                   s = new Triangle(x, y, newX, newY, newX + dx, newY - dy, color);
                }
                
                s.setFilled(fill);
                database.add(s);
            }
            
            x = newX;
            y = newY;
            selectedShape = null;
            repaint();
        }
    }
    
    private class PanelMotionListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            if (manipType.equals("Create") || manipType.equals("Delete"))
                return;
            
            int newX = e.getX();
            int newY = e.getY();
            selectedShape = database.containsPoint(newX, newY);
            if (selectedShape != null)
                selectedShape.move(newX, newY);
            x = newX;
            y = newY;
            selectedShape = null;
            repaint();
        }
    }
}
