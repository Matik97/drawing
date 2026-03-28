package pro1.drawingModel;

import pro1.swingComponents.MainFrame;

import java.awt.*;




public class Strom implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private MainFrame frame;

    public Strom( int x, int y, int width, int height, MainFrame frame ) {
      this.frame = frame;
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(Graphics2D g) {

        String barvaListu = this.frame.isBarevne() ? "#228B22" : "#808080";
        String barvaKmene = this.frame.isBarevne() ? "#8B4513" : "#A9A9A9";


        Drawable[] casti = new Drawable[] {
                new Rectangle(0, 0, 10, 30, barvaKmene),
                new Ellipse(-15, -30, 40, 40, barvaListu),
        };
                new Group(casti, this.x, this.y, 0, this.width, this.height).draw(g);

    }
}