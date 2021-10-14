/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.pkg10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 *
 * @author tommu
 */
public class ShapeGUI extends JFrame {
    
    private JMenuItem createMI = new JMenuItem("Create");
    private JMenuItem moveMI = new JMenuItem("Move");
    private JMenuItem deleteMI = new JMenuItem("Delete");
    private JMenuItem circleMI = new JMenuItem("Circle");
    private JMenuItem rectMI = new JMenuItem("Rectangle");
    private JMenuItem triangleMI = new JMenuItem("Triangle");
    private JMenuItem blackMI = new JMenuItem("Black");
    private JMenuItem redMI = new JMenuItem("Red");
    private JMenuItem blueMI = new JMenuItem("Blue");
    private JMenuItem greenMI = new JMenuItem("Green");
    private JMenuItem randomMI = new JMenuItem("Random");
    private JMenuItem fillYesMI = new JMenuItem("Yes");
    private JMenuItem fillNoMI = new JMenuItem("No");
    private ColorPanel panel = new ColorPanel(Color.white);
    
    public ShapeGUI () {
        JMenu shapeMenu = new JMenu("Shape");
        shapeMenu.add(createMI);
        shapeMenu.add(moveMI);
        shapeMenu.add(deleteMI);
        
        createMI.addActionListener( new CreateListener() );
        moveMI.addActionListener( new MoveListener() );
        deleteMI.addActionListener( new DeleteListener() );
        
        JMenu typeMenu = new JMenu("Type");
        typeMenu.add(circleMI);
        typeMenu.add(rectMI);
        typeMenu.add(triangleMI);
        
        circleMI.addActionListener( new CircleListener() );
        rectMI.addActionListener( new RectangleListener() );
        triangleMI.addActionListener( new TriangleListener() );
        
        JMenu colorMenu = new JMenu("Color");
        colorMenu.add(blackMI);
        colorMenu.add(redMI);;
        colorMenu.add(blueMI);
        colorMenu.add(greenMI);
        colorMenu.add(randomMI);
        
        blackMI.addActionListener( new BlackListener() );
        redMI.addActionListener( new RedListener() );
        blueMI.addActionListener( new BlueListener() );
        greenMI.addActionListener( new GreenListener() );
        randomMI.addActionListener( new RandomListener() );
        
        JMenu fillMenu = new JMenu("Fill");
        fillMenu.add(fillYesMI);
        fillMenu.add(fillNoMI);
        
        fillYesMI.addActionListener( new FillYesListener() );
        fillNoMI.addActionListener( new FillNoListener() );
        
        Container pane = getContentPane();
        JMenuBar menuBar = new JMenuBar();
        pane.add(menuBar, BorderLayout.NORTH);
        pane.add(panel, BorderLayout.CENTER);
        
        menuBar.add(shapeMenu);
        menuBar.add(typeMenu);
        menuBar.add(colorMenu);
        menuBar.add(fillMenu);
        
        setTitle("Shape GUI");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class CreateListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setManipType("Create");
        }
    }
    
    public class MoveListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setManipType("Move");
        }
    }
    
    public class DeleteListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setManipType("Delete");
        }
    }
    
    public class CircleListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setShapeType("Circle");
        }
    }
    
    public class RectangleListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setShapeType("Rectangle");
        }
    }
    
    public class TriangleListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setShapeType("Triangle");
        }
    }
    
    public class BlackListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setColor(Color.black);
        }
    }
    
    public class RedListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setColor(Color.red);
        }
    }
    
    public class BlueListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setColor(Color.blue);
        }
    }
    
    public class GreenListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setColor(Color.green);
        }
    }
    
    public class RandomListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            Random rand = new Random();
            panel.setColor( new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)) );
        }
    }
    
    public class FillYesListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setFilled(true);
        }
    }
    
    public class FillNoListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            panel.setFilled(false);
        }
    }
}
