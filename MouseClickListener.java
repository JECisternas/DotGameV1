
package dotgameapp;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseClickListener extends MouseAdapter
{
    private GamePanel panel;
    private int[][] parametersR;
    private int[][] parametersS;
    private int index;
    private int x;
    private int y;
    private int w;
    private int h;
    private int sq1;
    private int sq2;
    
    public MouseClickListener(GamePanel panel, int[][] parametersRectanglesArray, int[][] squaresArray) 
    {
        this.panel = panel;
        this.parametersR = parametersRectanglesArray;
        this.parametersS = squaresArray;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {   // Look for the parameters of the rectangle that was clicked
        // if the click is outside of a rectangle, nothing happens. index will be 0.
        FindRectangle rectangle = new FindRectangle(e.getX(),e.getY(),parametersR);
        index = rectangle.getPosition();
        x = rectangle.getX();
        y =  rectangle.getY();
        w = rectangle.getW();
        h = rectangle.getH();
        sq1 = rectangle.getSq1();
        sq2 = rectangle.getSq2();
        
        if (index != 0 && parametersR[index][8] == 0)
        // clicked inside rectangle && rectangle not claimed.
           panel.addRectangleFiller(new RectangleFiller(x,y,w,h,index,parametersR,parametersS,sq1,sq2)); //,panel));
    } 
}




