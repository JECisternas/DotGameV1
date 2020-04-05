package dotgameapp;
import java.awt.Color;
import java.awt.Graphics;
public class RectangleFiller 
{
    private int x;
    private int y;
    private int w;
    private int h;
    private int r;
    private int sq1;
    private int sq2;   
    private int xS1;
    private int yS1;
    private int xS2;
    private int yS2;  
    private int currentIndex;
    private Color color;
    private boolean claimed = false;
    private int[][]  parametersR; // Rectangles array
    private int[][]  parametersS; // Squares array
//    private GamePanel panel;
    
    public RectangleFiller(int x, int y,int w,int h, int indexFinded, int[][] parametersRectanglesArray,
            int[][] squaresArray ,int sq1, int sq2)//, GamePanel panel) 
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.sq1 = sq1;
        this.sq2 = sq2;
        this.currentIndex = indexFinded;
        this.parametersR = parametersRectanglesArray;
        this.parametersS = squaresArray;
    }
    public void draw(Graphics g)
    {
//        System.out.println("current INDEX at the beggining " + currentIndex + " " + this );
        int gameOver = 25; // odd number
        if (currentIndex !=0)   // Because loop not programed 
        {                       // is excecuted with every click. If it is the third click, this method 
                                // will be repeted 3 time itself and so on.
            switch(parametersR[0][8])
            {
                case(1):
                    color = Color.yellow;
                    xS1 = 0;
                    yS1 = 0;
                    xS2 = 0;
                    yS2 = 0;
                    claimRectangleAndSquare();

                    if (xS1 != 0 && yS1 != 0)
                    {
                        g.setColor(color);
                        g.fillRect(xS1, yS1, 39, 39);
                        parametersS[0][0] += 1; // Index [0,0] in Square Array is used to store the amount 
                                                //of squares claimed to know when the game is over.
                        parametersS[0][1] += 1; // Index [0,1] in Square Array is used to store the amount
                                                // claimed by PLAYER 1.
                                                // FIRST adjacent square
                        if (parametersS[0][0] == gameOver)
                        {
                            winner();
                        }                  
                    }
                    if (xS2 != 0 && yS2 != 0)
                    {
                        g.setColor(color);
                        g.fillRect(xS2, yS2, 39, 39);
                        parametersS[0][0] += 1; // Index [0,0] in Square Array is used to store the amount 
                                                //of squares claimed to know when the game is over
                        parametersS[0][1] += 1; // Index [0,1] in Square Array is used to store the amount
                                                // claimed by PLAYER 1.
                                                // SECOND adjacent square
                        if (parametersS[0][0] == gameOver)
                        {
                            winner();
                        }
                    }
                    if (xS1 == 0 && yS1 == 0 && xS2 == 0 && yS2 == 0)
                    {
                        changePlayer();
                    } 
                    if (claimed == false)
                    {
                        g.setColor(color);
                        g.fillRect(x, y, w, h);
                    }

                    break;
                case(2):
                    color = Color.GREEN;
                    xS1 = 0;
                    yS1 = 0;
                    xS2 = 0;
                    yS2 = 0;
                    claimRectangleAndSquare();
                    if (xS1 != 0 && yS1 != 0)
                    {
                        g.setColor(color);
                        g.fillRect(xS1, yS1, 39, 39);
                        parametersS[0][0] += 1; // Index [0,0] in Square Array is used to store the amount 
                                                //of squares claimed to know when the game is over
                        parametersS[0][2] += 1; // Index [0,1] in Square Array is used ti store the amount
                                                // claimed by PLAYER 2.
                                                // FIRST adjacent square
                        if (parametersS[0][0] == gameOver)
                        {
                            winner();
                        }
                    }
                    if (xS2 != 0 && yS2 != 0)
                    {
                        g.setColor(color);
                        g.fillRect(xS2, yS2, 39, 39);
                        parametersS[0][0] += 1; // Index [0,0] in Square Array is used to store the amount 
                                                //of squares claimed to know when the game is over
                        parametersS[0][2] += 1; // Index [0,1] in Square Array is used ti store the amount
                                                // claimed by PLAYER 2.
                                                // SECOND adjacent square
                        if (parametersS[0][0] == gameOver)
                        {
                            winner();
                        }
                    }
                    if (xS1 == 0 && yS1 == 0 && xS2 == 0 && yS2 == 0)
                    {
                        changePlayer(); 
                    }

                    if (claimed == false)
                    {
                        g.setColor(color);
                        g.fillRect(x, y, w, h);
                    } 
                    break;
                default:
                    break;
            }
        }  
    }
    
    public void claimRectangleAndSquare()
    {
        if(parametersR[currentIndex][8] == 0) // Current rectangle not claimed yet
        {
            claimed = false;   // rectangles will be painted
            r = 0;
            parametersR[currentIndex][8] = parametersR[0][8]; //rectangle claimed
            r = currentIndex; // assign the index of the current claimed rectangle
            
            //  For those rectangles that has only one square adjacent:
                // parametersR[currentIndex][6] that contains the index of the adjacent square.
            // For those rectangles that has two squares adjacent:
                // parametersR[currentIndex][6] that contains the index of the FIRST adjacent square.
                // parametersR[currentIndex][7] that contains the index of the SECOND adjacent square.
          
                    
            if ( parametersR[currentIndex][7] != 0) // The rectangle has a SECOND adjacent squares.
            {   // If the rectangle has two adjacent square then both clould be claimed.
                // So, it looks, in the Square Array(parametersS),  for the index of every 
                // rectangle surrounding the FIRST AND the SECOND adjacent square.    
                claimingTwoSquare();
                currentIndex = 0;
            }else{  // If the rectangle has just one adjacent square then 
                    // it looks, in the Square Array(parametersS),  for the index of every 
                    // rectangle surrounding the adjacent square  
                claimingOneSquare();
                currentIndex = 0;
            }
        }else{
            claimed = true; 
        }
    }
    
    public void claimingOneSquare()
    {   // r1,r2,r3,r4 contain the index of every rectangle surrounding the SECOND square.
        int r1;
        int r2;
        int r3;
        int r4;
        r1 = parametersS[parametersR[currentIndex][6]][3];   
        r2 = parametersS[parametersR[currentIndex][6]][4];
        r3 = parametersS[parametersR[currentIndex][6]][5];
        r4 = parametersS[parametersR[currentIndex][6]][6];
        if (r == r1)
        {   
            if (parametersR[r2][8] != 0 && parametersR[r3][8] != 0 && parametersR[r4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                claimTheSquare1();
            }
        }else if (r == r2)
        {
            if (parametersR[r1][8] != 0 && parametersR[r3][8] != 0 && parametersR[r4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                claimTheSquare1();
            }

        }else if (r == r3)
        {  
            if (parametersR[r2][8] != 0 && parametersR[r1][8] != 0 && parametersR[r4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            { 
               claimTheSquare1();
            }
        }else if (r == r4)
        {   
            if (parametersR[r2][8] != 0 && parametersR[r3][8] != 0 && parametersR[r1][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
               claimTheSquare1();        
            }
        }
    }
    public void claimingTwoSquare()
    {   // r1,r2,r3,r4 contain the index of every rectangle surrounding the SECOND square.
        int r1;
        int r2;
        int r3;
        int r4;
        r1 = parametersS[parametersR[currentIndex][7]][3];
        r2 = parametersS[parametersR[currentIndex][7]][4];
        r3 = parametersS[parametersR[currentIndex][7]][5];
        r4 = parametersS[parametersR[currentIndex][7]][6];     
        if (r == r1) // 3 == 3
        {   
            if (parametersR[r2][8] != 0 && parametersR[r3][8] != 0 && parametersR[r4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                claimTheSquare2();
                if(parametersS[0][0] != 81){
                    claimingTheSecondSquare();
                }else{
                    // do nothing game is over
                }
            }else{
                claimingTheSecondSquare();
            }
        }else if (r == r2)
        {
            if (parametersR[r1][8] != 0 && parametersR[r3][8] != 0 && parametersR[r4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                claimTheSquare2();
                if(parametersS[0][0] != 81){
                    claimingTheSecondSquare();
                }else{
                    // do nothing game is over
                }
            }else{
                claimingTheSecondSquare();
            }
        }else if (r == r3)
        {   
            if (parametersR[r2][8] != 0 && parametersR[r1][8] != 0 && parametersR[r4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                claimTheSquare2();
                if(parametersS[0][0] != 81){
                    claimingTheSecondSquare();
                }else{
                    // do nothing game is over
                }
            }else{
                claimingTheSecondSquare();
            }
        }else if (r == r4)
        {   
            if (parametersR[r2][8] != 0 && parametersR[r3][8] != 0 && parametersR[r1][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                claimTheSquare2();
                if(parametersS[0][0] != 81){
                    claimingTheSecondSquare();
                }else{
                    // do nothing game is over
                }
            }else{
                claimingTheSecondSquare();
            }
        } 
    
    }
    
 public void claimingTheSecondSquare()
    {
        int rr1;
        int rr2;
        int rr3;
        int rr4;

        rr1 = parametersS[parametersR[currentIndex][6]][3];
        rr2 = parametersS[parametersR[currentIndex][6]][4];
        rr3 = parametersS[parametersR[currentIndex][6]][5];
        rr4 = parametersS[parametersR[currentIndex][6]][6]; 
        
        if (r == rr1) // 3 == 3
        {  
            if (parametersR[rr2][8] != 0 && parametersR[rr3][8] != 0 && parametersR[rr4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                    claimTheSquare1();
            }else{

            }
        }else if (r == rr2)
        {
            if (parametersR[rr1][8] != 0 && parametersR[rr3][8] != 0 && parametersR[rr4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                    claimTheSquare1();
            }
        }else if (r == rr3)
        {   
            if (parametersR[rr2][8] != 0 && parametersR[rr1][8] != 0 && parametersR[rr4][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                    claimTheSquare1();
            }
        }else if (r == rr4)
        {   
            if (parametersR[rr2][8] != 0 && parametersR[rr3][8] != 0 && parametersR[rr1][8] != 0) 
            // The rest of rectangles has beenclaimed then claim the SQUARE
            {
                    claimTheSquare1();       
            }
        }        
        
    }    
    
    public void claimTheSquare1()
    {
        // Assign position (x,y) of the square for painting.
        
         parametersS[parametersR[currentIndex][6]][7] = parametersR[0][8]; // First Square claimed   
         xS1 = parametersS[parametersR[currentIndex][6]][0];
         yS1 = parametersS[parametersR[currentIndex][6]][1];
    }
    public void claimTheSquare2()
    {    
         parametersS[parametersR[currentIndex][7]][7] = parametersR[0][8];  // Second Square claimed                     
         xS2 = parametersS[parametersR[currentIndex][7]][0];
         yS2 = parametersS[parametersR[currentIndex][7]][1];
    }                  
    
    public void changePlayer()
    {
        if (parametersR[0][8] == 1)
        { 
            parametersR[0][8] = 2;
            currentIndex = 0; // to stop not programed loop 
        }
        else
        {
            parametersR[0][8] = 1;
            currentIndex = 0; // to stop not programed loop 
        }
    }
    public void winner()
    {
            String count1String;
            String count2String;
            String theWinnerIs;
            count1String = Integer.toString(parametersS[0][1]);
            count2String = Integer.toString(parametersS[0][2]);
            if(parametersS[0][1] > parametersS[0][2])
            {
                theWinnerIs = "YOU WIN ------>>";
            }else{
                theWinnerIs = "YOU WIN ------->>";
            }
            Winner winner = new  Winner(theWinnerIs,count1String,count2String);
            winner.theWinner();
    }
}