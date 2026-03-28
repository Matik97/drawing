package pro1.swingComponents;

import pro1.drawingModel.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPanel extends JPanel {

    Drawable drawable = null;
    private List<Drawable> drawables = new ArrayList<>();


    public DisplayPanel(){
        this.setBackground(Color.WHITE);
    }

    public void addDrawable(Drawable novyTvar) {
        this.drawables.add(novyTvar);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Drawable tvar : this.drawables) {
            tvar.draw((Graphics2D) g);
        }
    }
}