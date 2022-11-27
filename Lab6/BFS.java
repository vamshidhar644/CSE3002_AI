package Lab6;

class Node	
{
    Node children[]=null;
    Node parent=null;
    int puzzle[][]=null;
     
    Node(int p[][],Node pa)
    {
        puzzle=p;
        parent=pa;
    }
     
    public void print()  
    {
        System.out.println("**********");
        for (int i=0;i<puzzle.length;i++)       
        {
            for (int j=0;j<puzzle.length;j++)           
            {
                System.out.print(puzzle[i][j]);
            }
            System.out.println("");
        }
        System.out.println("**********");
    }
     
    public void printChildren()    
    {
        for (int i=0;i<4;i++)
        {
	        if(children[i]!=null)       
	        {
	            (children[i]).print();
	        }
	    }
    }
     
    public void expand()    {
        children=new Node[4];
        children[0]=expandDown();
        children[1]=expandUp();
        children[2]=expandLeft();
        children[3]=expandRight();
    }
     
    public Node expandDown()    {
        Node n=new Node(puzzle.clone(),this);
        int zeroXY[]=n.getZero();
        if(zeroXY[1]-1>0 && zeroXY[1]-1<puzzle.length)        {
            int temp=n.puzzle[zeroXY[0]][zeroXY[1]];
            n.puzzle[zeroXY[0]][zeroXY[1]]=n.puzzle[zeroXY[0]][zeroXY[1]-1];
            n.puzzle[zeroXY[0]][zeroXY[1]-1]=temp;
            n.print();
            return n;
        }
        else        {
            return null;
        }         
    }
    public Node expandUp()    {
        Node n=new Node(puzzle.clone(),this);
        int zeroXY[]=n.getZero();       
        if(zeroXY[1]+1>0 && zeroXY[1]+1<puzzle.length)        {
            int temp=n.puzzle[zeroXY[0]][zeroXY[1]];
            n.puzzle[zeroXY[0]][zeroXY[1]]=n.puzzle[zeroXY[0]][zeroXY[1]+1];
            n.puzzle[zeroXY[0]][zeroXY[1]+1]=temp;
            n.print();
            return n;
        }
        else        {
            return null;
        }
    }
    public Node expandRight()    {
        Node n=new Node(puzzle.clone(),this);
        int zeroXY[]=n.getZero();
        if(zeroXY[0]+1>0 && zeroXY[0]+1<puzzle.length)        {
            int temp=n.puzzle[zeroXY[0]][zeroXY[1]];
            n.puzzle[zeroXY[0]][zeroXY[1]]=n.puzzle[zeroXY[0]+1][zeroXY[1]];
            n.puzzle[zeroXY[0]+1][zeroXY[1]]=temp;
            n.print();
            return n;
        }
        else        {
            return null;
        }
    }
    public Node expandLeft()    {
        Node n=new Node(puzzle.clone(),this);
        int zeroXY []=n.getZero();
        if(zeroXY[0]-1>0 && zeroXY[0]-1<puzzle.length)        {
            int temp=n.puzzle[zeroXY[0]][zeroXY[1]];
            n.puzzle[zeroXY[0]][zeroXY[1]]=n.puzzle[zeroXY[0]-1][zeroXY[1]];
            n.puzzle[zeroXY[0]-1][zeroXY[1]]=temp;
            n.print();
            return n;
        }
        else {
            return null;
        }
    }
   
    int[] getZero()    {
        int[] n=new int[2];
        for (int i=0;i<puzzle.length;i++)  {
            for (int j=0;j<puzzle.length;j++)  {
                if(puzzle[i][j]==0)                {
                    n[0]=i;
                    n[1]=j;
                    return n;
                }
            }           
        }
        return null;
    }
}

class BFS{
    final static int GOAL [][]={{1,2,3},{4,5,6},{7,8,0}};   
    public static void main(String args[])    {
        int board[][]={{1,2,3},{4,5,6},{7,8,0}};    
    Node Start=new Node(board,null);
    Start.expand();
    Start.printChildren();  
    }
}