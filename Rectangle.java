
package dotgameapp;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle 
{
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    
    public Rectangle(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(x, y, w, h);
    }    
}
