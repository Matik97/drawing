package pro1.swingComponents;

import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;

    public MainFrame() {
        this.setTitle("PRO1 Drawing");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(
                new Dimension(200, 0));
        this.add(leftPanel, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                displayPanel.setDrawable(example(e.getX(), e.getY()));
            }
        });
    }

    private Drawable example(int x, int y) {
        var color = ColorUtils.randomColor();
        var d1 = new Ellipse(0, 0, 150, 250, color);
        var d2 = new Text(0, 0, color);
        var d3 = new Line(0, 50,170,170,3, color);
        return new Group(new Drawable[]{d1, d2, d3}, x, y, 40, 1, 1);
    }
}