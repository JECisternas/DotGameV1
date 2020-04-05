/*
Team Project: Dot Game
Jaime Cisternas-Riquelme
Jamie Batchelor
Alex Lawrence
Due Date : 12/02/2019
Assignment: A10 "Team Project"
Course Description: Fundamental concepts of programming with Java as tool.
*/
package dotgameapp;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DotGameApp extends JFrame
{
        JFrame window = new JFrame ("Dot Game");
        GamePanel panel = new GamePanel();
        
        int[][] parametersRectanglesArray;
        int[][] squaresArray;

        public static void main(String[] args) 
        {  

            DotGameApp mainClass = new  DotGameApp();

        }
        public DotGameApp()     // Draw the Game Board. 
                                // Draw Circles that represents dots.
                                // Draw Rectangles that represents lines.
                                // Draw Squares to be claimed.
                                // Store the parameters of every rectangle.
                                // Enumerate every square and assign every rectangle surrounding it
                                // Activate the MouseListener.
        {
            
            window.setContentPane(panel);
            window.setSize(700, 700);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setBackground(new Color(0, 183, 183));
            window.setResizable(false);
            window.setLocation(100, 50);
            window.setVisible(true); 
            
            drawCircles();
            drawRectangles();
            drawSquares();
            storeParametersOfRectangles();
            storeParametersOfSquares();                         
            panel.addMouseListener(new MouseClickListener
            (panel,parametersRectanglesArray,squaresArray)); // To detect the mouse click 
        }
 
        private void drawCircles()
        {
            // Drawing Circles of the Game Board
            for (int i = 100; i <= 550; i+=50)
            {
                for (int j = 100; j <= 550; j+=50)

                    panel.addCircle(new Circle (i,j,20,new Color(0,102,51)));
            }
        }
        
        private void drawRectangles()
        {
            // Drawing Horizontal outlined Rectangles of the Game Board
            for (int i = 120; i <= 550; i+=50)
            {
                for (int j = 105; j <= 555; j+=50)
                    panel.addRectangle(new Rectangle(i,j,30,10,Color.BLACK));
            }

            // Drawing Vertical outlined Rectangles of the Game Board
            for (int i = 105; i <= 555; i+=50)
            {
                for (int j = 120; j <= 550; j+=50)
                    panel.addRectangle(new Rectangle(i,j,10,30,Color.BLACK));
            }            
        }
        private void drawSquares()
        {
            // Drawing outlined Squares between rectangles of the Game Board
            for (int i = 116; i <= 516; i+=50)
            {
                for (int j = 116; j <= 516; j+=50)
                    panel.addSquares(new Squares(i,j,Color.pink));
            }            
        }
        
        private void storeParametersOfRectangles() 
        // Create an array to store parameters of rectangles
        {
            RectanglePosition recPosition = new RectanglePosition();
            recPosition.storePosition();
            parametersRectanglesArray = recPosition.getParameters();                     
        }
        
        private void storeParametersOfSquares()
        {
            SquareNum sqrPosition = new SquareNum(parametersRectanglesArray);
            sqrPosition.numSquares(); 
            sqrPosition.assignRectangles();  
            sqrPosition.assignSquaresToRectangles();
            squaresArray = sqrPosition.getSquaresEnum();
        }
}

