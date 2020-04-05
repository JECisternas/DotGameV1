package dotgameapp;

public class RectanglePosition 
{
    private int[][] parametersR = new int[181][10]; // Store parameters of rectangles
    // 2-Dimension Array to store:
    // (x0,y0), (x1,y1), width(w), height(h), 
    // index of the first adjacent square, index of the second adjacent square, player
    // x0,x1,y0,y1,w,h, square1,square2, player. Index(0,1,2,3,4,5,6,7,8)

    public int[][] getParameters() 
    {
        return parametersR;
    }
    public void storePosition()
    {
        int limit = 18;
        int index = 0;
        for (int x = 105; x <= 505; x+=50) //Capture position of vertical rectangles
        {
            for (int y = 120; y <= 520; y+=50)
            {
                if (index == limit)
                {
                    limit +=19;
                    index = index + 3;
                }
                else
                {
                    index +=2;
                }
                parametersR[index][0] = x;
                parametersR[index][1] = x + 10;
                parametersR[index][2] = y;
                parametersR[index][3] = y + 30;
                parametersR[index][4] = 10;
                parametersR[index][5] = 30;
            }                
        }
        limit = 19;
        index = -1;
        for (int x = 120; x <= 520; x+=50) //Capture position of horizontal rectangles
        {
            for (int y = 105; y <= 555; y+=50)
            {
                if (index == limit)
                {
                    limit +=19;
                    index = index + 1;
                }
                else
                {
                    index +=2;
                }
                parametersR[index][0] = x;
                parametersR[index][1] = x + 30;
                parametersR[index][2] = y;
                parametersR[index][3] = y + 10;                
                parametersR[index][4] = 30;
                parametersR[index][5] = 10;
            }                
        }        
        index = 172;
        for (int y = 120; y <= 520; y+=50) //Capture position of the last column of vertical rectangles
        {
            parametersR[index][0] = 555;
            parametersR[index][1] = 555 + 10;
            parametersR[index][2] = y;
            parametersR[index][3] = y + 30;
            parametersR[index][4] = 10;
            parametersR[index][5] = 30;
            index +=1;
        }
        parametersR[0][8] = 1;  // Row 0 in Rectangle Array is not being used. 
                                // So, it will be used to handle the number of player.
                                // This let be passed throughout the classes in the Array.

    }
}
