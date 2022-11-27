package Lab11;

/**
 * Used to perform the Iterative Deepening A* Algorithm to find the shortest path from a start to a target node.
 */
public class IterativeDeepening 
{   
    public static double iterativeDeepeningAStar(int[][] tree, double[][] heuristic, int start, int goal) 
    {
        double threshold = heuristic[start][goal];
        while (true) 
        {
            System.out.printf("Iteration with threshold: %.2f\n", threshold);
            double distance = iterativeDeepening(tree, heuristic, start, goal, 0, threshold);
            if (distance == Double.MAX_VALUE) 
            {
                // Node not found and no more nodes to visit
                return -1;
            } 
            else if (distance < 0) 
            {
                // if we found the node, the function returns the negative distance
                System.out.println("Found the node we're looking for!");
                return -distance;
            } else 
            {
                // if it hasn't found the node, it returns the (positive) next-bigger threshold
                threshold = distance;
            }
        }
    }

    private static double iterativeDeepening(int[][] tree, double[][] heuristic, int node, int goal, double distance, double threshold) 
    {
        System.out.println("Visiting Node " + node);

        if (node == goal) 
        {
            // We have found the goal node we we're searching for
            return -distance;
        }

        double estimate = distance + heuristic[node][goal];
        if (estimate > threshold) 
        {
            System.out.printf("Breached threshold with heuristic: %.2f\n", estimate);
            return estimate;
        }

        //...then, for all neighboring nodes....
        double min = Double.MAX_VALUE;
        for (int i = 0; i < tree[node].length; i++) 
        {
            if (tree[node][i] != 0) 
            {
                double t = iterativeDeepening(tree, heuristic, i, goal, distance + tree[node][i], threshold);
                if (t < 0) 
                {
                    // Node found
                    return t;
                } else if (t < min) 
                {
                    min = t;
                }
            }
        }
        return min;
    }
    
    public static void main(String[] args)
	{
		
	}
}