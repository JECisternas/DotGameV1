package dotgameapp;
import java.awt.Color;
import java.awt.Graphics;
public class Circle 
{
    private int x;
    private int y;
    private int diameter;
    private Color color;

    public Circle(int x, int y, int diameter, Color color) 
    {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}
