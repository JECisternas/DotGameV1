package dotgameapp;
import java.awt.Color;
import java.awt.Graphics;
public class Squares 
{
    private int x;
    private int y;
    private int w = 39;
    private int h = 39;
    private Color color;

    public Squares(int x, int y, Color color) 
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(x, y, w, h);
    }    
}
