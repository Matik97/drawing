package pro1.swingComponents;

import pro1.drawingModel.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private DisplayPanel displayPanel;
    private int x;
    private int y;
    private OptionsPanel optionsPanel;

    public MainFrame() {
        this.setTitle("PRO1 Drawing");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        this.optionsPanel = new OptionsPanel(this);
        this.add(this.optionsPanel, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MainFrame.this.x = e.getX();
                MainFrame.this.y = e.getY();
                MainFrame.this.showExample();
            }
        });

        optionsPanel.getColorCheckBox().addActionListener(e -> {
            displayPanel.repaint();
        });
    }

    public void showExample(){
        MainFrame.this.displayPanel.addDrawable(this.example());
    }


    private Drawable example() {
        int velikost = this.optionsPanel.getScaleValue();
        return new Strom(this.x, this.y, velikost, velikost, this);

    }
    public boolean isBarevne() {
        return this.optionsPanel.isBarevne();   }


    public void clearTrees() {
        this.displayPanel.clear();
    }
}