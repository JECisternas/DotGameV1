package dotgameapp;

public class SquareNum 
{
    private int[][] squaresEnum = new int[82][8]; // Store parameters of squares 
    // 2-Dimension Array to store: 
    // position (x,y), width(wh (w=h)),
    // Number(index in rectangle array) of rectangles surrounding the square 
    // Rec1,Rec2,Rec3,Rec4. 
    // Player that claimed the square (1 or 2)
    // x, y, wh, Rec1, Rec2, Rec3, Rec4, player Index(0,1,2,3,4,5,6,7)
    
    private int[][] parametersR; // To pass Rectangles Array

    public SquareNum(int[][] parameters) 
    {
        this.parametersR = parameters;
    }
    public SquareNum() 
    {
       // dammy Constructor   
    }
    public void numSquares() // enumerate squares from 1 to 81. The index is the number.
    { 
        int limit = 9;
        int index = 0;

        for (int x = 116; x <= 516; x+=50) 
        // Capture the squares position to store it in the Squares Array
        {
            for (int y = 116; y <= 516; y+=50)
            {
                if (index == limit)
                {
                    limit +=9;
                    index = index + 1;
                }
                else
                {
                    index +=1;
                }
                squaresEnum[index][0] = x;
                squaresEnum[index][1] = y;
            }                
        }
    }

    public int[][] getSquaresEnum() 
    {
        return squaresEnum;
    }
    
    public void assignRectangles() 
    // assign to squares, the number of rectangles that surround every square.
    {
        int numRectangles = 1;
        int stopFor = 0;
        int indexSquare = 1;
        while(numRectangles <= 171)
        {
            for (int i = indexSquare; i <= stopFor + 9; i++)
            {
            squaresEnum[i][2] = 39;
            squaresEnum[i][3] = numRectangles;
            squaresEnum[i][4] = numRectangles+1;
            squaresEnum[i][5] = numRectangles+2;
            squaresEnum[i][6] = numRectangles + 20;
            squaresEnum[i][7] = 0;
            numRectangles +=2;     
            }
            numRectangles += 1;
            indexSquare += 9;
            stopFor += 9;
        }
        
        numRectangles = 172;
        for (int i = 73; i <= 81; i++)
        // The loop before does not work for last columns of 9 squares.
        // So this loop corrects the position for squares between 73 to 81
        {
            squaresEnum[i][6] = numRectangles;
            numRectangles +=1;     
        }
    }

    public void assignSquaresToRectangles()   
    // There are rectangles have two squares adjacentes.        
    {
        for (int i = 1;i < this.squaresEnum.length;i++)
        {
            for(int j = 3; j <= 6; j++)
            {
                if (parametersR[this.squaresEnum[i][j]][6] == 0)
                    parametersR[this.squaresEnum[i][j]][6] = i;
                else
                {
                    parametersR[this.squaresEnum[i][j]][7] = i;
                }
            }
        }

    }    
}
