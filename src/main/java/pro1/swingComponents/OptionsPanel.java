package pro1.swingComponents;


import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final MainFrame parent;
    public JSlider scaleSlider;


    public JCheckBox colorCheckBox;
    {
    colorCheckBox =new JCheckBox("Barevné stromy",true);
    this.add(colorCheckBox);
}
    public JCheckBox getColorCheckBox() {
        return this.colorCheckBox;
    }

    public OptionsPanel(MainFrame parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(200, 0));
        this.add(new JLabel("Velikost stromu:"));
        this.scaleSlider = new JSlider(1, 10, 2);
        this.add(this.scaleSlider);


        JButton resetBtn = new JButton("Vymazat stromy");
        this.add(resetBtn);

        resetBtn.addActionListener(e -> {
            this.parent.clearTrees();
        });
    }


    public boolean isBarevne() {
        return colorCheckBox.isSelected();
    }
    public int getScaleValue() {
        return this.scaleSlider.getValue();
    }
}
