package Lab3;

public class EightQueens 
{
	 static final int N = 8;
	    
	    static void Solution(String[][] Chess)
	    {
	        for (int i = 0; i < N; i++)
	        {
	            for (int j = 0; j < N; j++)
	                System.out.print(" " + Chess[i][j] + " ");
	            System.out.println();
	        }
	    }
	 
	    static boolean isSafe(String[][] Chess, int row, int column)
	    {
	        int i, j;
	        
	        for (i = 0; i < column; i++)
	            if (Chess[row][i] == "X")
	                return false;
	 
	        
	        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
	            if (Chess[i][j] == "X")
	                return false;
	             
	        for (i = row, j = column; j >= 0 && i < N; i++, j--)
	            if (Chess[i][j] == "X")
	                return false;
	 
	        return true;
	    }
	    
	    
	    public static boolean solve8Queen(String[][] Chess, int column)
	    {
	        if (column >= N)
	            return true;
	 
	        for (int i = 0; i < N; i++) 
	        {
	            if (isSafe(Chess, i, column)) 
	            {
	            	Chess[i][column] = "X";
	 
	                if (solve8Queen(Chess, column + 1))
	                    return true;
	 
	                Chess[i][column] = "0";
	            }
	        }
	        return false;
	    }
	 
	    public static void main(String args[])
	    {
	        String Chess[][] = {{"0","0","0","0","0","0","0","0"}, {"0","0","0","0","0","0","0","0"},
	        					{"0","0","0","0","0","0","0","0"}, {"0","0","0","0","0","0","0","0"},
				        		{"0","0","0","0","0","0","0","0"}, {"0","0","0","0","0","0","0","0"}, 
				        		{"0","0","0","0","0","0","0","0"}, {"0","0","0","0","0","0","0","0"}};
	        
	        if (!solve8Queen(Chess, 0)) {
	            System.out.print("Solution does not exist");
	            return;
	        }
	        System.out.println("8 QUEENS PROBLEM");
	        Solution(Chess);
	        
	    }
}
