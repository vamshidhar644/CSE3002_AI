package Lab10;

class BestFirstSearch 
{
    int finish = 1;
    int[][] start = {{0, 1, 3}, {8, 2, 4}, {7, 6, 5}};
    int[][] goal = {{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};
    int[][] start1 = new int[3][3];
    int[] f = new int[4];
    int[] old = new int[9];
    
    int mv = 0, x, y, lvl = 1, h = 0, x1 = 0, y1 = 0, x2, y2, temp, a, b, flag = 0;
    
    public static void main(String[] args) 
    {
        new BestFirstSearch().go();
    }
    
    void go() 
    {
        while (finish == 1) 
        {
            finish = 0;
            chkmove();
            for (int i = 0; i < 3; i++) 
            {
                for (int j = 0; j < 3; j++) 
                {
                    if (start[i][j] != goal[i][j]) 
                    {
                        finish = 1;
                    }
                 }
             }
         }
        
        if (finish == 0) 
        {
            System.out.println("The puzzle can be solved in " + (lvl - 1) + " moves");
            return;
        }
    }

    void move(int i, int j)     {
        if (((i % 2 == 0) && (j % 2 == 0)) && ((i + j) % 2 == 0))         {
            mv = 2;
        } 
        else if (((i % 2 != 0) && (j % 2 != 0)) && ((i + j) % 2 == 0))      {
            mv = 4;
        } 
        else if ((i + j) % 2 == 1)    {
            mv = 3;
        }
    }

    void chkmove()    {
        int g = 1, h = 0;
        for (x = 0; x < 3; x++)   {
            for (y = 0; y < 3; y++) {
                if (start[x][y] == 0) 
                {
                    x1 = x;
                    y1 = y;
                    old[lvl - 1] = (x1 * 2) + (x1 + y1);
                }
            }
        }
        
        move(x1, y1);
        
        if (mv == 2)  
        {
            a = -2;
            b = 1;
            for (int count = 0; count < mv; count++) 
            {
                x2 = x1 + (a * (x1 - 1)) / 2;
                y2 = y1 + (b * (y1 - 1)) / 2;
                for (int i = 0; i < lvl; i++) 
                {
                    if (((x2 * 2) + (x2 + y2)) == old[i]) 
                    {
                        flag = 1;
                    }
                }
                
                if (flag == 0) 
                {
                    temp = start[x1][y1];
                    start[x1][y1] = start[x2][y2];
                    start[x2][y2] = temp;
                    calc(count);
                    temp = start[x1][y1];
                    start[x1][y1] = start[x2][y2];
                    start[x2][y2] = temp;
                }
                a = 1;
                b = -2;
                flag = 0;
            }
        }
        
        if (mv == 3) 
        {
            a = 1;
            b = 0;
            for (int count = 0; count < mv; count++) 
            {
                if (x1 == 1) 
                {
                    x2 = x1 + a;
                    y2 = y1 + b;
                    b = 0;
                } 
                
                else if (y1 == 1) 
                {
                    x2 = x1 + b;
                    y2 = y1 + a;
                    b = 0;
                }
                
                for (int i = 0; i < lvl; i++) 
                {
                    if (((x2 * 2) + (x2 + y2)) == old[i]) 
                    {
                        flag = 1;
                    }
                }
                
                if (flag == 0) {
                    temp = start[x1][y1];
                    start[x1][y1] = start[x2][y2];
                    start[x2][y2] = temp;
                    calc(count);
                    temp = start[x1][y1];
                    start[x1][y1] = start[x2][y2];
                    start[x2][y2] = temp;
                    a--;
                }
                
                if (a == 0)   {
                    b = (x1 - 1) * (-1);
                }
                
                flag = 0;
            }
        }
        
        if (mv == 4)   {
            a = 1;
            b = 0;
            for (int count = 0; count < mv; count++)   {
                x2 = x1 + a;
                y2 = y1 + b;
                for (int i = 0; i < lvl; i++)  {
                    if (((x2 * 2) + (x2 + y2)) == old[i])  {
                        flag = 1;
                    }
                }
                
                if (flag == 0) 
                {
                    temp = start[x1][y1];
                    start[x1][y1] = start[x2][y2];
                    start[x2][y2] = temp;
                    calc(count);
                    temp = start[x1][y1];
                    start[x1][y1] = start[x2][y2];
                    start[x2][y2] = temp;
                }
                
                a = -a;
                temp = a;
                a = b;
                b = temp;
                flag = 0;
            }
        }
        
        for (int i = 0; i < 3; i++)   {
            for (int j = 0; j < 3; j++)  {
            	start[i][j] = start1[i][j];
                System.out.print(start[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        lvl++;
        finish = 0;
    }

    void calc(int c)    {
        for (int i = 0; i < 3; i++)       
        {
            for (int j = 0; j < 3; j++) 
            {
                if (start[i][j] != goal[i][j]) 
                {
                    h++;
                }
            }
        }
        
        f[c] = lvl + h;
        if (c == 0) {
            for (int i = 0; i < 3; i++)  
            {
                for (int j = 0; j < 3; j++)  
                {
                    start1[i][j] = start[i][j];
                }
            }
        }
        
        if (c > 0) 
        {
            if (f[0] > f[c]) 
            {
                f[0] = f[c];
                for (int i = 0; i < 3; i++) 
                {
                    for (int j = 0; j < 3; j++) 
                    {
                        start1[i][j] = start[i][j];
                    }
                }
            }
        }
        h = 0;
    }
}