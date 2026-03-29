package pro1.swingComponents;

import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final MainFrame parent;
    private JSlider rSlider;
    private JSlider gSlider;
    private JSlider bSlider;



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
        JButton newColorBtn = new JButton("Náhodná barva");
        this.add(newColorBtn);
        newColorBtn.addActionListener(
                (e)-> {
                    this.parent.setColor(ColorUtils.randomColor());
                    this.parent.showExample();
                }
        );
        this.rSlider = new JSlider(0,255,0);
        this.add(this.rSlider);
        this.rSlider.addChangeListener((e)->this.sliderChanged());
    }

    private void sliderChanged(){
        this.parent.setColor(ColorUtils.color(
                this.rSlider.getValue(),
               this.gSlider.getValue(),
               this.bSlider.getValue()
        ));
        this.parent.showExample();
    }
    public boolean isBarevne() {
        return colorCheckBox.isSelected();
    }
}
