package dotgameapp;

public class FindRectangle 
{
    private int x;
    private int y;   
    private int w;
    private int h;
    private int sq1;
    private int sq2;
    private int index = 0;
    private int[][]  parametersR;
    private int player;

    public FindRectangle(int x, int y, int[][] parameters) {
        this.x = x;
        this.y = y;    
        this.parametersR = parameters;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getW() 
    {
        return w;
    }
    public int getH() 
    {
        return h;
    }    
    public int getSq1() {
        return sq1;
    }

    public int getSq2() {
        return sq2;
    }
        
    public int getPosition()
    {
        for (int i = 1; i < parametersR.length; i++)
        {
            if (x > parametersR[i][0] && x < parametersR[i][1] && y > parametersR[i][2] && y < parametersR[i][3])
            {
                if (parametersR[i][6] != 0)  //  put an eyes
                {
                    index = i; 
                    x =  parametersR[i][0];
                    y =  parametersR[i][2];
                    w =  parametersR[i][4];
                    h =  parametersR[i][5];
                    sq1 = parametersR[i][6];
                    sq2 = parametersR[i][7];
                    player = parametersR[i][8];
                    break;
                }    
            }
        }
        return index;
            
    }    
    
}
