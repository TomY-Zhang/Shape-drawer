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
public class ShapeModel {
    
    private Shape[] arrShapes = new Shape[10];
    private int size = 0;
    
    public Shape getShape (int index) {
        if (0 <= index && index < size)
            return arrShapes[index];
        
        return null;
    }
    
    public int size() {
        return size;
    }
    
    public void add (Shape s) {
        if (size < arrShapes.length) 
            arrShapes[size++] = s;
        else {
            Shape[] arr = new Shape[arrShapes.length + 10];
            System.arraycopy(arrShapes, 0, arr, 0, size);
            arrShapes = arr;
            arrShapes[size++] = s;
        }
    }
    
    public void replace (Shape s, int index) {
        if (0 <= index && index < size)
            arrShapes[index] = s;
    }
    
    public void remove (Shape s) {
        Shape[] arr = new Shape[arrShapes.length];
        
        int index = -1;
        for (int i = 0; i < size; i++)
            if (arrShapes[i].equals(s)) {
                index = i;
                break;
            }
        
        if (-1 < index)
            for (int i = 0, j = 0; i < size; i++) { 
                if (i == index)
                    continue;

                arr[j++] = arrShapes[i];
            }
        arrShapes = arr;
        size--;
    }
    
    public void draw (Graphics g) {
        for (int i = 0; i < size; i++)
            arrShapes[i].draw(g);
    }
    
    public Shape containsPoint (int x, int y) {
        for (int i = 0; i < size; i++)
            if (arrShapes[i].containsPoint(x, y))
                return arrShapes[i];
        
        return null;
    }
}
