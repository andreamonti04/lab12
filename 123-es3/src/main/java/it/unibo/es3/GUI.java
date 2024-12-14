package it.unibo.es3;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.util.List;

public class GUI extends JFrame {
    
    private final Map<JButton, Pair<Integer, Integer>> cells = new HashMap<>();
    private final JButton expand = new JButton(">");
    private final Logics logic; 
    
    public GUI(int width) {
        this.logic = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(expand, BorderLayout.SOUTH);
        
        expand.addActionListener(e -> {
            logic.toStart();
            this.upView();
            if(logic.toQuit()){
                System.exit(0);
            }
        });
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                final JButton jb = new JButton(" ");
                this.cells.put(jb, new Pair<Integer, Integer>(i, j));
                panel.add(jb);
            }
        }
        this.upView();
        this.setVisible(true);
    }

    private void upView() {
    	List<Pair<Integer,Integer>> list = logic.getPos();
    	cells.forEach((b,p)-> b.setText(list.contains(p) ? "*" : " "));
    }
    
}