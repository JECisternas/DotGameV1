package dotgameapp;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    private ArrayList<RectangleFiller> rectanglesFiller = new ArrayList<RectangleFiller>();
    private ArrayList<Squares> squaresFiller = new ArrayList<Squares>();
    private ArrayList<String> labels = new ArrayList<>();

    public void addCircle(Circle circle)
    {
        circles.add(circle);
        repaint();
    }        
    
    public void addRectangle(Rectangle rectangle)
    {
        rectangles.add(rectangle);
        repaint();
    }          
 
    public void addRectangleFiller(RectangleFiller rectangleFiller)
    {
        rectanglesFiller.add(rectangleFiller);
        repaint();
    } 
    
    public void addSquares(Squares squares)
    {
        squaresFiller.add(squares);
        repaint();
    } 
    
    public void addLabels(String labelW, String count1, String count2)
    {
        // To print results of the game.
        labels.add(labelW);
        labels.add(count1);
        labels.add(count2);
        
    }     
    public void paint(Graphics g)
    {
        for(Rectangle r: rectangles){
            r.draw(g);
        }    
        for(Circle c: circles){
            c.draw(g);  
        }

        for(RectangleFiller f: rectanglesFiller){
            f.draw(g);
        }    
        for(Squares s: squaresFiller){
            s.draw(g);
        }            
        
    }  
}








